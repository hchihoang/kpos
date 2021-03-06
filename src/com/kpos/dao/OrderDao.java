package com.kpos.dao;

import com.kpos.domain.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kkwang
 * Date: 4/3/12
 * Time: 8:20 PM
 */
@Repository
public class OrderDao extends AbstractJpaDao<Order> implements IOrderDao {
    @Override
    protected Class getEntityClass() {
        return Order.class;
    }
    
    public List<Order> fetchAllOrdersByTime(boolean isASC) {
        Query namedQuery;
        if(isASC) {
            namedQuery = entityManager.createNamedQuery("listOrdersByTimeASC");
        } else {
            namedQuery = entityManager.createNamedQuery("listOrdersByTimeDESC");
        }
        return (List<Order>)namedQuery.getResultList();
    }
    
    public List<Order> fetchOrdersForStatusByTime(int aStatus, boolean isASC) {
        Query namedQuery;
        if(isASC) {
            namedQuery = entityManager.createNamedQuery("listOrdersForStatusByTimeASC");
        } else {
            namedQuery = entityManager.createNamedQuery("listOrdersForStatusByTimeDESC");
        }
        namedQuery.setParameter("aStatus", aStatus);
        return (List<Order>)namedQuery.getResultList();
    }
    
    public List<Order> fetchOrdersForTable(long aTableId, int aStatus) {
        Query namedQuery = entityManager.createNamedQuery("listOrdersForTable");
        namedQuery.setParameter("aId", aTableId);
        namedQuery.setParameter("aStatus", aStatus);
        return (List<Order>)namedQuery.getResultList();
    }
    
    public List<Order> fetchOrdersForDateRange(Date aStart, Date aEnd) {
        Query namedQuery = entityManager.createNamedQuery("listOrdersForTable");
        namedQuery.setParameter("aStart", aStart);
        namedQuery.setParameter("aEnd", aEnd);
        return (List<Order>)namedQuery.getResultList();
    }

    public List<Order> fetchOrdersForDateRangeStatus(Date aStart, Date aEnd, int aStatus) {
        Query namedQuery = entityManager.createNamedQuery("listOrdersForDateRangeAndStatus");
        namedQuery.setParameter("aStart", aStart);
        namedQuery.setParameter("aEnd", aEnd);
        namedQuery.setParameter("aStatus", aStatus);
        return (List<Order>)namedQuery.getResultList();
    }
    
    public List<Order> fetchUnservedOrders(boolean isAsc) {
        Query namedQuery;
        if(isAsc) {
            namedQuery = entityManager.createNamedQuery("listUnservedOrdersByTimeASC");
        } else {
            namedQuery = entityManager.createNamedQuery("listUnservedOrdersByTimeDESC");
        }
        return (List<Order>)namedQuery.getResultList();
    }
    
    public List<Order> fetchOpenOrdersByServer(long userId) {
        Query namedQuery = entityManager.createNamedQuery("listOpenOrdersForServer");
        namedQuery.setParameter("aUserId", userId);

        Date today = new Date();
        Calendar todayCal = Calendar.getInstance();
        todayCal.setTime(today);
        todayCal.set(Calendar.HOUR, 0);
        todayCal.set(Calendar.MINUTE, 0);
        todayCal.set(Calendar.SECOND, 0);
        namedQuery.setParameter("aStart", new Date());

        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);        
        namedQuery.setParameter("aEnd", cal.getTime());
        return (List<Order>)namedQuery.getResultList();
    }
    
    public List<Order> findTodayOrderByNumber(long aNum, long aBase) {
        Query namedQuery = entityManager.createNamedQuery("findTodayOrderByNum");
        namedQuery.setParameter("aId", aNum);
        namedQuery.setParameter("aBase", aBase);
        return (List<Order>)namedQuery.getResultList();
    }
}

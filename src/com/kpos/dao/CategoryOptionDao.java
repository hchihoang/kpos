package com.kpos.dao;

import com.kpos.domain.CategoryOption;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: kkwang
 * Date: 4/2/12
 */
@Repository
public class CategoryOptionDao extends AbstractJpaDao<CategoryOption> implements ICategoryOptionDao {
    @Override
    protected Class getEntityClass() {
        return CategoryOption.class;
    }
}

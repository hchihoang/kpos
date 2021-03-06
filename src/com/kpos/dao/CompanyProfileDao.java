package com.kpos.dao;

import com.kpos.domain.CompanyProfile;
import org.springframework.stereotype.Repository;

/**
 * Created by kpos.
 * Author: kkwang
 * Date: 5/27/12 5:20 PM
 */
@Repository
public class CompanyProfileDao extends AbstractJpaDao<CompanyProfile> implements ICompanyDao {
    @Override
    protected Class getEntityClass() {
        return CompanyProfile.class;
    }
}

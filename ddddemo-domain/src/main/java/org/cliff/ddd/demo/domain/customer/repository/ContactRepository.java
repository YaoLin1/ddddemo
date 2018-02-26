package org.cliff.ddd.demo.domain.customer.repository;

import com.alibaba.sofa.context.TenantContext;
import com.alibaba.sofa.repository.RepositoryI;
import org.cliff.ddd.demo.domain.customer.entity.ContactE;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ContactRepository implements RepositoryI {

	public Set<ContactE> queryContactByGlobalId(String globalId, String type){
		TenantContext.getTenantId();
		TenantContext.getBizCode();
		return null;
	}

}

package org.cliff.ddd.demo.domain.customer.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.sofa.domain.DomainFactoryI;
import org.cliff.ddd.demo.domain.customer.entity.CustomerE;
import org.cliff.ddd.demo.domain.customer.repository.ContactRepository;

@Component
public class CustomerDomainFactory implements DomainFactoryI<CustomerE>{

	@Autowired
	private ContactRepository contactRepository;

	public CustomerE create(){
		return new CustomerE();
	}

}

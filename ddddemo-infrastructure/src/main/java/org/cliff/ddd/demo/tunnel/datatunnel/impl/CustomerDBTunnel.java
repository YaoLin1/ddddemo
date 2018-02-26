package org.cliff.ddd.demo.tunnel.datatunnel.impl;

import org.apache.commons.lang3.RandomUtils;
import org.apache.ibatis.annotations.Mapper;
import org.cliff.ddd.demo.dao.CustomerDOMapper;
import org.cliff.ddd.demo.tunnel.dataobject.CustomerDO;
import org.cliff.ddd.demo.tunnel.datatunnel.CustomerTunnelI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public class CustomerDBTunnel implements CustomerTunnelI {

    @Autowired
    private CustomerDOMapper customerDOMapper;

    @Override
    public CustomerDO create(CustomerDO customerDo) {
        customerDo =new CustomerDO();
        customerDo.setCustomerId("8" + RandomUtils.nextLong(1,100000));
        customerDo.setCompanyName("杭州XX公司");
        customerDo.setCompanyType("VIP");
        customerDo.setGlobalId(RandomUtils.nextLong(1,100000)+"");
        customerDo.setMemberId("m"+RandomUtils.nextLong(1,100000));
        customerDOMapper.insert(customerDo);
        return  customerDo;
    }
    
    @Override
    public void update(CustomerDO customerDo) {
        
    }
    
    @Override
    public CustomerDO get(String id) {
        CustomerDO customerDo = new CustomerDO();//just for demo
        return customerDo;
    }

    @Override
    public List<CustomerDO> findByCriteria(String... params) {
        return customerDOMapper.selectByParams(null,null,0,20);
    }

	@Override
	public List<CustomerDO> getByEntity(CustomerDO arg0) {
		return null;
	}

}

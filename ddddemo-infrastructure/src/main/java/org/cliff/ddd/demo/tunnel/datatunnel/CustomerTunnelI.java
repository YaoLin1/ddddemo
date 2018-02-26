package org.cliff.ddd.demo.tunnel.datatunnel;

import com.alibaba.sofa.repository.DataTunnel;
import org.cliff.ddd.demo.tunnel.dataobject.CustomerDO;

import java.util.List;

public interface CustomerTunnelI extends DataTunnel<CustomerDO>{

    public List<CustomerDO> findByCriteria(String... params);

}

package org.cliff.ddd.demo.dto;

import org.cliff.ddd.demo.dto.clientobject.CustomerCO;
import com.alibaba.sofa.dto.Command;
import lombok.Data;

@Data
public class CustomerAddCmd extends Command{

    private CustomerCO customer;
    
}

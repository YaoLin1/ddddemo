package org.cliff.ddd.demo.assembler;

import com.alibaba.sofa.assembler.AssemblerI;
import org.cliff.ddd.demo.dto.clientobject.CustomerCO;

import java.util.HashMap;
import java.util.Map;

public class CustomerAssembler implements AssemblerI{

	public Map<String, String> assembleQueryParam(CustomerCO customerCO) {
		
		return new HashMap<>();
	}
}

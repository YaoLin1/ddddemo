package org.cliff.ddd.demo.validator;

import com.alibaba.sofa.logger.Logger;
import com.alibaba.sofa.logger.LoggerFactory;
import org.cliff.ddd.demo.dto.CustomerAddCmd;
import org.cliff.ddd.demo.validator.extensionpoint.CustomerAddValidatorExtPt;
import org.springframework.stereotype.Component;

@Component
public class CustomerAddValidator implements CustomerAddValidatorExtPt {

	private Logger logger = LoggerFactory.getLogger(CustomerAddValidator.class);
	
	@Override
	public void validate(Object candidate) {
		logger.debug("Do common validation");
		CustomerAddCmd addCmd = (CustomerAddCmd)candidate;
	}
}

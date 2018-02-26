package org.cliff.ddd.demo.interceptor;

import com.alibaba.sofa.command.CommandInterceptorI;
import com.alibaba.sofa.command.PreInterceptor;
import com.alibaba.sofa.dto.Command;
import com.alibaba.sofa.logger.Logger;
import com.alibaba.sofa.logger.LoggerFactory;

@PreInterceptor
public class LoggerPreInterceptor implements CommandInterceptorI{
    
    Logger logger = LoggerFactory.getLogger(LoggerPreInterceptor.class);
    
    @Override
    public void preIntercept(Command command) {
        logger.debug("Begin to process "+ command);
    }

}

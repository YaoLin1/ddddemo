package org.cliff.ddd.demo.interceptor;

import com.alibaba.sofa.command.CommandInterceptorI;
import com.alibaba.sofa.command.PostInterceptor;
import com.alibaba.sofa.dto.Command;
import com.alibaba.sofa.dto.Response;
import com.alibaba.sofa.logger.Logger;
import com.alibaba.sofa.logger.LoggerFactory;

@PostInterceptor
public class LoggerPostInterceptor implements CommandInterceptorI{
    
    Logger logger = LoggerFactory.getLogger(LoggerPostInterceptor.class);
    
    @Override
    public void postIntercept(Command command, Response response) {
        logger.debug("Finished processing "+ command.getClass()+" Response:"+response);
    }

}
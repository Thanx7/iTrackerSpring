package org.training.itracker.listener;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class ServletContextUtils implements ServletContextAware{

private ServletContext ctx;

    public void setServletContext(ServletContext ctx) {
     this.ctx = ctx;
    }
    
    public String getRealPath(){
     return ctx.getRealPath("/");
    }

}
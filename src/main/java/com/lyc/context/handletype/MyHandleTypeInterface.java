package com.lyc.context.handletype;

import com.lyc.servlet.TestServlet;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyHandleTypeInterface implements HandleTypeInterface {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /*DispatcherServlet dispatcherServlet = new DispatcherServlet();
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        dynamic.setLoadOnStartup(0);
        dynamic.addMapping("/");*/

        TestServlet testServlet = new TestServlet();
        ServletRegistration.Dynamic testServletDynamic = servletContext.addServlet("testServlet", testServlet);
        testServletDynamic.addMapping("/test");

    }
}

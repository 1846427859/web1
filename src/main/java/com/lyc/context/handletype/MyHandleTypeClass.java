package com.lyc.context.handletype;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyHandleTypeClass extends HandleTypeClass {

    @Override
    protected void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("MyHandleTypeClass..........");
    }
}

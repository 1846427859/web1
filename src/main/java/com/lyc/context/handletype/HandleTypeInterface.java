package com.lyc.context.handletype;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public interface HandleTypeInterface {

    void onStartup(ServletContext servletContext) throws ServletException;

}

package com.lyc.context.initializer;

import com.lyc.context.handletype.HandleTypeClass;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * - @HandlesTypes(value = {HandleTypeClass.class})
 * - 证明了只能拿到子类，不能拿到 @HandlesTypes 中定义的类
 */
@HandlesTypes(value = {HandleTypeClass.class})
public class HeServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println(set);
    }
}

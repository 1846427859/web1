package com.lyc.context.initializer;

import com.lyc.context.handletype.HandleTypeInterface;
import org.springframework.util.ReflectionUtils;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@HandlesTypes(value = {HandleTypeInterface.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

        List<HandleTypeInterface> htiInstance = new LinkedList<>();

        if (set != null) {
            for (Class<?> clazz : set) {
                if (!clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers()) &&
                        HandleTypeInterface.class.isAssignableFrom(clazz)) {
                    try {
                        HandleTypeInterface hti = (HandleTypeInterface) ReflectionUtils.accessibleConstructor(clazz).newInstance();
                        htiInstance.add(hti);
                    }
                    catch (Throwable ex) {
                        throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
                    }
                }
            }
        }

        for(HandleTypeInterface hti : htiInstance) {
            hti.onStartup(servletContext);
        }
    }
}

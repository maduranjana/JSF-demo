package com.mj.jsf.config;

import jakarta.faces.webapp.FacesServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsfConfig {
    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
        ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
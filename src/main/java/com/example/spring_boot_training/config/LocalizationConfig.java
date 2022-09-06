package com.example.spring_boot_training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

public class LocalizationConfig {

    /** Create LocaleResolver **/
    @Bean
    public LocaleResolver localeResolver(){
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.GERMAN);
        return localeResolver;
    }

//    /** Create LocaleChangeInterceptor **/
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor(){
//        LocaleChangeInterceptor mylci = new LocaleChangeInterceptor();
//        mylci.setParamName("name");
//        return mylci;
//    }
//
//    /** Add **/
//    public void addInterceptors(InterceptorRegistry interceptorRegistry){
//        interceptorRegistry.addInterceptor(localeChangeInterceptor());
//    }
}

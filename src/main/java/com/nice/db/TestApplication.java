package com.nice.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author ningh
 */
@Component
//@Configuration
public class TestApplication implements ApplicationContextAware {

    private ApplicationContext applicationContext;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getClass().getName());
    }
}

package com.ReCarChoi.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author 蔡江楠
 * @version 1.0
 * @date 2021/12/15 20:48
 * @description TODO
 */
@Configuration
@SuppressWarnings("all")
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控:web.xml
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        //用户名和密码形式固定，否则报告空指针异常
        initParameters.put("loginUsername", "ReCarChoi");
        initParameters.put("loginPassword", "572019");
        initParameters.put("allow", "");
        bean.setInitParameters(initParameters);
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //可以过滤那些请求
        HashMap<String, String> initParameters = new HashMap<>();
        //过滤以下
        initParameters.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }

}

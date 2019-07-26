package com.czxy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Spring框架的配置类
 * @author Administrator
 */
@Configuration // 是配置类
@ComponentScan(basePackages="com.czxy") // 扫描指定的包结构
@EnableTransactionManagement // 打开事务注解
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
   @Value("${jdbc.driver}")
   private String driver;

   @Value("${jdbc.url}")
   private String url;

   @Value("${jdbc.username}")
   private String username;

   @Value("${jdbc.password}")
   private String password;
   @Bean
   public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
      return new PropertySourcesPlaceholderConfigurer();
   }

   @Bean
   public DataSource dataSource(){
      DruidDataSource dataSource = new DruidDataSource();
      dataSource.setDriverClassName(driver);
      dataSource.setUrl(url);
      dataSource.setUsername(username);
      dataSource.setPassword(password);
      return dataSource;
   }
   
   /**
    * 配置平台事务管理器对象，需要连接池对象
    */
   @Bean
   @Resource
   public PlatformTransactionManager createTransactionManager(DataSource dataSource) {
      return new DataSourceTransactionManager(dataSource);
   }
   
}

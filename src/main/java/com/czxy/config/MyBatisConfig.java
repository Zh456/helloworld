package com.czxy.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Spring整合MyBatis的配置类
 * @author Administrator
 */
@Configuration    // 声明是配置类
public class MyBatisConfig {
   
   /**
    * 构建SessionFactory对象
    * @param dataSource
    * @return
    * @throws Exception
    */
   @Bean
   @Resource
   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
      // 1.通过工厂bean创建对象，最后需要调用 getObject()获得具体的对象
      SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      // 1.1 设置数据源
      factoryBean.setDataSource(dataSource);
      // 1.2 设置别名包扫描
      factoryBean.setTypeAliasesPackage("com.czxy.domain");
      // 1.3 全局配置：驼峰映射
      org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
      //  数据库中字段 cust_name  默认使用驼峰命名的规则，JavaBean custName
      config.setMapUnderscoreToCamelCase(true);
      factoryBean.setConfiguration(config);
      
      // 2 插件配置
      // 2.1 分页插件
      PageHelper pageHelper = new PageHelper();
      Properties pageProps = new Properties();
      pageProps.setProperty("dialect", "mysql");
      pageProps.setProperty("rowBoundsWithCount", "true");
      pageHelper.setProperties(pageProps);
      factoryBean.setPlugins(new Interceptor[] { pageHelper });
      
      // 3 通过工厂bean获得 sqlSessionFactory
      return factoryBean.getObject();
   }
   
   /**
    * 扫描com.czxy.dao下所有Mapper接口，把mapper对象存入到IOC容器中
    * @return
    */
   @Bean
   public MapperScannerConfigurer mapperScanner() {
      MapperScannerConfigurer configurer = new MapperScannerConfigurer();
      configurer.setBasePackage("com.czxy.dao");
      return configurer;
   }
   
}
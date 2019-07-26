package com.czxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Springmvc框架的配置类
 * @author Administrator
 */
@Configuration    // 配置类
@EnableWebMvc     // 让mvc框架相关注解生效 解决日期的问题 2018/11/11 2018-1-1 DateTimeForart
public class SpringmvcConfig extends WebMvcConfigurerAdapter {
   
   /**
    * 视图解析器对象（帮助咱们跳转到页面）
    */
//   @Bean
//   public InternalResourceViewResolver createViewResolver() {
//      // 创建视图解析器对象
//      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//      // 设置jsp所在文件夹
//      resolver.setPrefix("/WEB-INF/jsp/");
//      // 设置后缀名
//      resolver.setSuffix(".jsp");
//      return resolver;
//   }

   
   /**
    * 文件上传解析器对象，如果做文件上传，必须配置。
    */
   @Bean
   public CommonsMultipartResolver multipartResolver(){
       CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
       // 设置上传文件总大小
       multipartResolver.setMaxInMemorySize(1000*1024*1024);
       // 设置单个文件的大小
       multipartResolver.setMaxUploadSize(1024000);
       return multipartResolver;
   }



   /**
    * 注册拦截器对象
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }
}
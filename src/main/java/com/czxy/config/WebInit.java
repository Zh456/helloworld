package com.czxy.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 启动项的类，服务器启动，方法就会执行，实现接口
 * 
 * @author Administrator
 */
public class WebInit implements WebApplicationInitializer {

   /**
    * 服务器启动，方法就会执行 1. 创建IOC容器，加载配置类 2. 设置解决post请求中文乱码过滤器 3. 创建DispartServlet对象
    */
   @Override
   public void onStartup(ServletContext servletContext) throws ServletException {
      // 1. 创建IOC容器，加载配置类
      AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
      // 加载配置类
      ac.register(SpringConfig.class);
      ac.register(MyBatisConfig.class);
      ac.register(SpringmvcConfig.class);
      // 设置servletContext
      ac.setServletContext(servletContext);

      // 2. 设置解决post请求中文乱码过滤器
      Dynamic filter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter("UTF-8"));
      // 拦截哪些资源
      filter.addMappingForUrlPatterns(null, true, "/*");

      // 3. 创建DispartServlet对象
      javax.servlet.ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet",
            new DispatcherServlet(ac));
      // 拦截.do结尾的请求
      servlet.addMapping("*.action");
      // 设置服务器启动就创建
      servlet.setLoadOnStartup(1);
   }

}
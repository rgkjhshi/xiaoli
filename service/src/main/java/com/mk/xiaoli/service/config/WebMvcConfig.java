package com.mk.xiaoli.service.config;

import com.mk.xiaoli.service.interceptor.VueHistoryInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 配置类, 等同于web.xml
 *
 * @author shisong02
 * @since 2020-10-20
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private VueHistoryInterceptor vueHistoryInterceptor;

    /**
     * 跨域访问， 参考：https://blog.csdn.net/qq_44606649/article/details/110679724
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin")
                .allowCredentials(true);
    }

    /**
     * 添加拦截器
     * addPathPatterns 用于添加拦截规则, excludePathPatterns 用户排除拦截
     * /**： 匹配所有路径
     * /admin/**：匹配 /admin/ 下的所有路径
     * /secure/*：只匹配 /secure/user，不匹配 /secure/user/info
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加用户vue后处理拦截器
        registry.addInterceptor(vueHistoryInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/api/**", "/static/**", "/public/**", "/data/**");
    }
}

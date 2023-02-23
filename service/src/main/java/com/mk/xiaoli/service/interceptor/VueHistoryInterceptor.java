package com.mk.xiaoli.service.interceptor;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 针对vue router中的history模式拦截器，url匹配不到任何静态资源或者在白名单（即此url交由vue处理）时，则应该返回index.html
 *
 * @author shisong
 * @since 2019-12-31
 */
@Component
public class VueHistoryInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        if (request.getMethod().equals(HttpMethod.GET.name()) && response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            if (null == modelAndView) {
                modelAndView = new ModelAndView();
            }
            // 保证浏览器不报错，如果是404则更改为200
            modelAndView.setStatus(HttpStatus.OK);
            modelAndView.setViewName("index.html");
        }
    }

}

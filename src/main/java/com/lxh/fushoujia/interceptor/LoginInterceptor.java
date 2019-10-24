package com.lxh.fushoujia.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lxh.fushoujia.pojo.User;
import com.lxh.fushoujia.util.JwtUtil;
import com.lxh.fushoujia.util.Result;
import com.lxh.fushoujia.util.Util;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: fushoujia
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-10 13:15
 **/

public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    然后进入拦截器链,
     *    从最后一个拦截器往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpServletResponse res = httpServletResponse;
        res.setCharacterEncoding("UTF-8");
        HttpServletRequest req = httpServletRequest;
        HttpSession session = req.getSession();
        //System.out.println(session.getId());
        /*User user = (User) session.getAttribute("loginUser");
        if (user != null ) {
            //System.out.println(user.getName());
        }*/
        //验证token是否存在
        String token = req.getHeader("token");
        //System.out.println(token);
        if (token != null) {
            //验证token是否匹配
            boolean b = JwtUtil.verify(token);
            if (b) {
                return true;
            }
        }
        Result result = new Result("登录状态已失效，请重新登录！", "615");
        res.getWriter().write(new ObjectMapper().writeValueAsString(result));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

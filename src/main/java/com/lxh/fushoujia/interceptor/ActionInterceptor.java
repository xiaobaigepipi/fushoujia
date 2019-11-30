package com.lxh.fushoujia.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxh.fushoujia.pojo.*;
import com.lxh.fushoujia.service.UserService;
import com.lxh.fushoujia.util.JwtUtil;
import com.lxh.fushoujia.util.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/*
 * @PackageName: com.lxh.fushoujia.interceptor
 * @ClassName: ActionInterceptor
 * @Description:
 * @author: 辉
 * @date: 2019/11/29 17:07
 * */
public class ActionInterceptor  extends HandlerInterceptorAdapter {

    @Autowired
    UserService userService;

    public ActionInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        int uid = JwtUtil.getUserId(token);
        User user = userService.getUserAction(uid);
        List<Action> list = new ArrayList<>();
        List<UserRole> userRoles = user.getUserRoles();
        //获取所有权限
        for (UserRole ur : userRoles) {
            Role role = ur.getRole();
            List<RoleAction> roleActions = role.getRoleActions();
            for (RoleAction ra : roleActions) {
                Action a = ra.getAction();
                list.add(a);
            }
        }

        String contextPath = request.getContextPath();
        String path = request.getRequestURI();
        String[] paths = StringUtils.split(path, '/');
        String actionPath = null;
        if (paths.length > 1){
            actionPath = "/" + paths[1];
            //System.out.println(actionPath);
        }
        if (actionPath == null) {
            return true;
        }
        if (actionPath.equals("/project")) {
            return true;
        }
        if (actionPath.equals("/user")){
            return true;
        }
        if (actionPath.equals("/all")) {
            return true;
        }
        if (actionPath.equals("/login")) {
            return true;
        }
        boolean b = false;
        for (Action action : list) {
            //System.out.println(actionPath);
            if (actionPath.equals(action.getUrl())) {
                b = true;
                //System.out.println(actionPath);
                //System.out.println(action.getUrl());
            }
        }
        if (b) {
            return true;
        }
        Result result = new Result("登录状态已失效，请重新登录！", "666");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}

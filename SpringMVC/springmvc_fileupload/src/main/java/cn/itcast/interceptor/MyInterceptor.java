package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 预处理方法,controller方法执行前
     * return true  放行  执行下一个拦截器,如果没有,执行controller中的方法
     * return false  不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行了");
        Object user = request.getSession().getAttribute("user");
        if (user ==null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
}

package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class ZfsExceptionResolver implements HandlerExceptionResolver{
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ZfsException ex = null;
        if (e instanceof ZfsException){
            ex = (ZfsException)e;
        }else {
            ex = new ZfsException("系统正在维护");
        }
        //创建ModelAndView对象 
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg",ex.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

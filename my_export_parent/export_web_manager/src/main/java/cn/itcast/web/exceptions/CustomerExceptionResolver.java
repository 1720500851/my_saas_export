package cn.itcast.web.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author TongHu
 * @date 2021/1/10 - 21:36
 *
 *      自定义异常类
 *          1 . 自定义一个类, 实现HandlerExceptionResolver 接口
 *          2.  实现接口中的方法
 *          3. 创建异常类处理对象
 */
@Component
public class CustomerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        // 创建modelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        // 保存异常信息到ModelAndView
        modelAndView.addObject("errorMsg", ex.getMessage());
        // 设置返回的视图名称
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

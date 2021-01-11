package cn.itcast.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TongHu
 * @date 2021/1/11 - 11:32
 */
@Controller
public class LoginController {

    /**
     * 登入的的方法
     * url: login.do
     * 作用: index.jsp 跳转到登入主页
     * */
    @RequestMapping("/login")
    public String login(){
        return "home/main";
    }

    /**
     * 显示主页内容的方法
     * url: home.do
     * 作用: 用于显示主页的内容
     * */
    @RequestMapping("/home")
    public String home(){
        return "home/home";
    }
}

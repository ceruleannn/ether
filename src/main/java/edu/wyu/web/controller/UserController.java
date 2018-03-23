package edu.wyu.web.controller;

import edu.wyu.domain.User;
import edu.wyu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 *
 *
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Inject()
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list.do")
    public String list(HttpServletRequest request){
        List<User> users = userService.list();
        for (User user : users) {
            System.out.println(user.getPhone());
        }
        return "/haha";
    }

    @RequestMapping("/sign.do")
    public String sign(HttpServletRequest request){
        userService.register("13522222222","166666");
        return "/haha";
    }

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request){
        User user = userService.login("13522222222","166666");

        if (user==null){
            System.out.println("登陆失败");
        }
        else {
            request.getSession().setAttribute("user",user);
            System.out.println("登陆成功");
        }

        return "/haha";
    }

    @RequestMapping("/edit.do")
    public String edit(HttpServletRequest request){
        userService.editPassword("13522222222","aaaaaa");

        return "/haha";
    }
}

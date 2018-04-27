package edu.wyu.web.controller;

import edu.wyu.domain.UserEntity;
import edu.wyu.service.UserService;
import edu.wyu.util.StringUtils;
import edu.wyu.web.util.SmsUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/u")
public class UserController {

    private UserService userService;

    @Inject()
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list.do")
    public String list(HttpServletRequest request){
        List<UserEntity> users = userService.list();
        for (UserEntity user : users) {
            System.out.println(user.getUsername());
        }
        return "/haha";
    }

    @RequestMapping("/sign")
    public String sign(HttpServletRequest request){
        return "/register";
    }

    @RequestMapping("/sign.do")
    @ResponseBody
    public String signDo(HttpServletRequest request){
        String result = checkCode(request);
        if (result==null){
            return "{\"code\":\"400\"}";
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.getParameter("username"));
        user.setPhone(request.getParameter("phone"));
        user.setPassword(request.getParameter("password"));

        if (!userService.register(user)){
            return "{\"code\":\"300\"}";
        }

        request.getSession().removeAttribute("code");
        request.getSession().setAttribute("user",user);
        return "{\"code\":\"200\"}";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "/index";
    }


    @RequestMapping("/login2")
    public String login(HttpServletRequest request){
        return "/login";
    }

    @RequestMapping("/login.do")
    @ResponseBody
    public String loginDo(HttpServletRequest request){
        UserEntity user = userService.login(request.getParameter("phone"),request.getParameter("password"));

        if (user==null){
            return "{\"code\":\"400\"}";
        }
        else {
            request.getSession().setAttribute("user",user);
            return "{\"code\":\"200\"}";
        }
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request){

        return "/edit";
    }

    @RequestMapping("/edit.do")
    @ResponseBody
    public String editDo(HttpServletRequest request){

        String result = checkCode(request);
        if (result!=null){
            return result;
        }

        UserEntity user = userService.editPassword(request.getParameter("phone"),request.getParameter("password"));

        if (user==null){
            return "{\"code\":\"400\"}";
        }

        request.getSession().removeAttribute("code");
        request.getSession().setAttribute("user",user);
        return "{\"code\":\"200\"}";
    }

    @RequestMapping("/sms")
    @ResponseBody
    public String sms(HttpServletRequest request){
        String phone = request.getParameter("phone");
        String action = request.getParameter("action");

        //无效的手机
        if (!StringUtils.validatePhoneValid(phone.trim())){
            return "{\"code\":\"400\"}";
        }

        boolean isExist = userService.checkPhoneExist(phone);

        //存在+修改 / 不存在+注册
        if ((isExist&&"edit".equals(action))||(!isExist)&&"register".equals(action)){
            String code = SmsUtils.send(phone);
            request.getSession().setAttribute("code",code);
            return  "{\"code\":\"200\"}";
        }else{
            return "{\"code\":\"400\"}";
        }

    }

    private String checkCode(HttpServletRequest request){
        String paramCode = request.getParameter("code");
        if (paramCode==null){
            return "/404";
        }


        String sessionCode = (String) request.getSession().getAttribute("code");

        if (!paramCode.equals(sessionCode)){
            return "{\"code\":\"400\"}";
        }

        return null;

    }
}

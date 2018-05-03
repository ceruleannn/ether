package edu.wyu.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
    @ResponseBody
    public String list(HttpServletRequest request){
        List<UserEntity> users = userService.list();
        for (UserEntity user : users) {
            user.setPassword("");
        }
        return "{\"data\":"+JSON.toJSONString(users)+"}";
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

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request){

        String action = request.getParameter("action");
        if ("start".equals(action)){
            String uid = request.getParameter("uid");
            userService.start(uid);
        }
        else if ("stop".equals(action)){
            String uid = request.getParameter("uid");
            userService.stop(uid);
        }
        else if ("update".equals(action)){
            UserEntity user = new UserEntity();
            user.setUid(Integer.parseInt(request.getParameter("uid")));
            user.setUsername(request.getParameter("username"));
            user.setPhone(request.getParameter("phone"));
            user.setAddress(request.getParameter("address"));
            user.setStatus(request.getParameter("status"));
            user.setSex(request.getParameter("sex"));
            user.setRealname(request.getParameter("realname"));
            user.setMail(request.getParameter("mail"));

            userService.update(user);
        }
        else if ("delete".equals(action)){
            String uid = request.getParameter("uid");
            userService.delete(uid);
        }

        return null;
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

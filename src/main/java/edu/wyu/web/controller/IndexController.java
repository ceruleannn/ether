package edu.wyu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 *
 *
 *
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
        return "/index";
    }

    @RequestMapping("/admin/index")
    public String adminIndex(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
        return "/adminIndex";
    }
}

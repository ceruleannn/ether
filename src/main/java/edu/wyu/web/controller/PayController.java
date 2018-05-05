package edu.wyu.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.wyu.web.util.PaySaPi;
import edu.wyu.web.util.PayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/pays")
public class PayController {

    @RequestMapping("/payhmtl")
    public String payhmtl(HttpServletRequest request, float price, int istype) {

        return "/pay";
    }

    @RequestMapping("/pay")
    @ResponseBody
    public Map<String, Object> pay(HttpServletRequest request, float price, int istype) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> remoteMap = new HashMap<String, Object>();
        remoteMap.put("price", price);
        remoteMap.put("istype", istype);
        remoteMap.put("orderid", PayUtil.getOrderIdByUUId());
        remoteMap.put("orderuid", "1");
        remoteMap.put("goodsname", "显卡");

        resultMap.put("data", PayUtil.payOrder(remoteMap));
        resultMap.put("code",1);
        resultMap.put("msg","ok");

        return resultMap;
    }

    @RequestMapping("/notifyPay")
    public void notifyPay(HttpServletRequest request, HttpServletResponse response, PaySaPi paySaPi) {
        System.out.println("access notify");
        if (PayUtil.checkPayKey(paySaPi)) {
            // TODO 做自己想做的
        } else {
            // TODO 该怎么做就怎么做
        }
    }

    @RequestMapping("/returnPay")
    public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response, String orderid) {
        System.out.println("access returnPay");
        boolean isTrue = false;
        ModelAndView view = null;
        // 根据订单号查找相应的记录:根据结果跳转到不同的页面
        if (isTrue) {
            view = new ModelAndView("/正确的跳转地址");
        } else {
            view = new ModelAndView("/没有支付成功的地址");
        }
        return view;
    }
}

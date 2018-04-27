package edu.wyu.web.controller;

import com.alibaba.fastjson.JSON;
import edu.wyu.domain.OrderEntity;
import edu.wyu.domain.ProductEntity;
import edu.wyu.domain.UserEntity;
import edu.wyu.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/o")
public class OrderController {

    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    @Inject
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/order")
    public String detail(HttpServletRequest request){

        return "/order";
    }

    @RequestMapping("/order.do")
    @ResponseBody
    public String detailDo(HttpServletRequest request){

        UserEntity user = (UserEntity)request.getSession().getAttribute("user");
        if (user==null){
            return "/404";
        }

        List<OrderEntity> list = orderService.listByUid(Integer.toString(user.getUid()));
        if (list==null){
            return "/404";
        }

        return  JSON.toJSONString(list);

    }
}

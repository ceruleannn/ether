package edu.wyu.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import edu.wyu.domain.*;
import edu.wyu.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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

    @RequestMapping("/gotProduct")
    @ResponseBody
    public String gotProduct(HttpServletRequest request){

        String oid = request.getParameter("oid");
        OrderEntity orderEntity = orderService.getOrderDao().get(oid);

        UserEntity userEntity = (UserEntity)request.getSession().getAttribute("user");
        if (!orderEntity.getUser().getPhone().equals(userEntity.getPhone())){
            return null;
        }

        orderService.gotProduct(orderEntity);
        return "{\"url\":\"/o/order\"}";

    }



    @RequestMapping("/admin")
    @ResponseBody
    public String admin(HttpServletRequest request, HttpServletResponse response){

        String action = request.getParameter("action");
        if ("query".equals(action)){
            String queryStatus = request.getParameter("status");
            List<OrderEntity> list = orderService.listByStatus(queryStatus);

            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(OrderEntity.class, "oid","phone","address","totalPrice","date","status","deliverid","deliverCompany");
            return "{\"data\":"+JSON.toJSONString(list, filter)+"}";
        }
        else if ("deliver".equals(action)){
            String oid = request.getParameter("oid");
            String deliverCompany = request.getParameter("deliverCompany");
            String deliverid = request.getParameter("deliverid");
            System.out.println(oid+"-"+deliverCompany+"-"+deliverid);
            orderService.deliver(oid,deliverCompany,deliverid);
        }

        else if ("delete".equals(action)){
            String oid = request.getParameter("oid");
            orderService.delete(oid);
        }
        else if ("add".equals(action)){

        }else if ("queryDetail".equals(action)){
            String oid = request.getParameter("oid");
            OrderEntity orderEntity = orderService.getOrderDao().get(oid);
            return "{\"data\":"+JSON.toJSONString(orderEntity)+"}";
        }

        return null;
    }
}

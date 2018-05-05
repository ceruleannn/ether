package edu.wyu.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import edu.wyu.domain.OrderDetailEntity;
import edu.wyu.domain.OrderEntity;
import edu.wyu.domain.ProductEntity;
import edu.wyu.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/c")
public class CartController {

    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    @Inject
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/checkout")
    public String checkout(HttpServletRequest request){

        return "/checkout";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest request){

        String pid = request.getParameter("pid");
        Integer number = Integer.parseInt(request.getParameter("number"));

        OrderDetailEntity detailEntity = new OrderDetailEntity();
        ProductEntity productEntity = productService.getProductDao().get(pid);
        detailEntity.setProduct(productEntity);

        detailEntity.setNumber(number);
        detailEntity.setPid(Integer.parseInt(pid));
        detailEntity.setPrice(productEntity.getPrice()*number);

        List<OrderDetailEntity> list = (List<OrderDetailEntity>) request.getSession().getAttribute("orderdetails");
        if (list==null){
            list = new ArrayList<>();
            list.add(detailEntity);
            request.getSession().setAttribute("orderdetails",list);
        }else {
            list.add(detailEntity);
        }

        return "{}";
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String remove(HttpServletRequest request){

        String pid = request.getParameter("pid");

        List<OrderDetailEntity> list = (List<OrderDetailEntity>) request.getSession().getAttribute("orderdetails");

        OrderDetailEntity remove = null;
        for (OrderDetailEntity detailEntity : list) {
            if (detailEntity.getPid()==Integer.parseInt(pid)){
                remove = detailEntity;
            }
        }
        list.remove(remove);
        return "{}";
    }

    @RequestMapping("/list")
    @ResponseBody
    public String list(HttpServletRequest request){

        List<OrderDetailEntity> list = (List<OrderDetailEntity>) request.getSession().getAttribute("orderdetails");

        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(OrderDetailEntity.class, "price","number","product");
        return "{\"data\":"+JSON.toJSONString(list, filter)+"}";
    }

}

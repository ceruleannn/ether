package edu.wyu.web.controller;

import com.alibaba.fastjson.JSON;
import edu.wyu.domain.ProductEntity;
import edu.wyu.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 *
 *
 */
@Controller
@RequestMapping("/p")
public class ProductController {

    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    @Inject
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, HttpServletRequest request){
        ProductEntity product = productService.getProductByID(Integer.parseInt(id));
        if (product==null){
            return "/404";
        }
        System.out.println(product.getDetail1());

        request.setAttribute("product", product);
        return "/detail";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request){

        return "/list";
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public String listDo(HttpServletRequest request){
        String tid = request.getParameter("tid");
        String bid = request.getParameter("bid");
        String order = request.getParameter("order");

        List<ProductEntity> products = productService.list(tid,bid,order);
        if (products==null){
            return "/404";
        }

        request.setAttribute("products", products);
        System.out.println(JSON.toJSONString(products));
        return  JSON.toJSONString(products);
    }

}

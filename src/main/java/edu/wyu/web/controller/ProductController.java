package edu.wyu.web.controller;

import edu.wyu.domain.ProductEntity;
import edu.wyu.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
        String tid = request.getParameter("tid");
        String bid = request.getParameter("bid");

        List<ProductEntity> products = productService.list(tid,bid);
        if (products==null){
            return "/404";
        }

        request.setAttribute("products", products);
        return "/list";
    }

}

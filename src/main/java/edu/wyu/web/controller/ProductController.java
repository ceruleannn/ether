package edu.wyu.web.controller;

import com.alibaba.fastjson.JSON;
import edu.wyu.domain.ProductEntity;
import edu.wyu.domain.SysBrandEntity;
import edu.wyu.domain.SysTypeEntity;
import edu.wyu.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
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
        request.setAttribute("product", product);
        return "/detail";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request){

        String type = request.getParameter("type");
        if (type!=null){
            request.setAttribute("type",Integer.parseInt(type));
            return "/list";
        }
        return "/404";
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public String listDo(HttpServletRequest request){
        String tid = request.getParameter("tid");
        String bid = request.getParameter("bid");
        String action = request.getParameter("action");

        if ("admin".equals(action)){
            List<ProductEntity> products = productService.list(tid,bid,"time2");
            List<adminBean> adminBeans = new ArrayList<>();

            for (ProductEntity product : products) {
                adminBean adminBean = new adminBean();
                adminBean.setPid(product.getPid());
                adminBean.setName(product.getName());
                adminBean.setName2(product.getName2());
                adminBean.setOldprice(product.getOldprice());
                adminBean.setPrice(product.getPrice());
                adminBean.setDate(product.getDate());
                adminBean.setStatus(product.getStatus());
                adminBean.setSales(product.getSales());
                adminBeans.add(adminBean);
            }

            return "{\"data\":"+JSON.toJSONString(adminBeans)+"}";

        }else {
            String order = request.getParameter("order");
            List<ProductEntity> products = productService.list(tid,bid,order);

            return  JSON.toJSONString(products);
        }

    }

    @RequestMapping("/imgUpload")
    @ResponseBody
    public String imgUpload(@RequestParam("file")MultipartFile[] files, HttpServletRequest request){

        Object obj = request.getSession().getAttribute("imgs");
        try {
            ArrayList<byte[]> list;
            if (obj!=null && obj instanceof ArrayList){
                list = (ArrayList<byte[]>) obj;

            }else {
                list = new ArrayList<>();
                request.getSession().setAttribute("imgs",list);
            }
            for (MultipartFile file : files) {
                if (file!=null){
                    byte[] bytes = file.getBytes();
                    list.add(bytes);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "{\"status\":500}";
        }

        return "{\"status\":200}";
    }



    @RequestMapping("/admin")
    public String admin(HttpServletRequest request){

        String action = request.getParameter("action");
        if ("start".equals(action)){
            String pid = request.getParameter("pid");
            productService.start(pid);
        }
        else if ("stop".equals(action)){
            String pid = request.getParameter("pid");
            productService.stop(pid);
        }

        else if ("delete".equals(action)){
            String pid = request.getParameter("pid");
            productService.delete(pid);
        }
        else if ("add".equals(action)){

            System.out.println("access product add");

            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(request.getParameter("name"));
            productEntity.setName2(request.getParameter("name1"));
            productEntity.setOldprice(Double.parseDouble(request.getParameter("oldprice")));
            productEntity.setPrice(Double.parseDouble(request.getParameter("price")));

            SysBrandEntity brandEntity = new SysBrandEntity();
            brandEntity.setBid(Integer.parseInt(request.getParameter("brand")));
            productEntity.setBrand(brandEntity);

            SysTypeEntity typeEntity = new SysTypeEntity();
            typeEntity.setTid(Integer.parseInt(request.getParameter("type")));
            productEntity.setType(typeEntity);

            productEntity.setOverview(request.getParameter("overview"));
            productEntity.setDetail1(request.getParameter("detail1"));
            productEntity.setDetail2(request.getParameter("detail2"));
            productEntity.setDetail3(request.getParameter("detail3"));
            productEntity.setStatus("启用");

            productEntity.setSales(0);
            productEntity.setDate(new Timestamp(System.currentTimeMillis()));

            @SuppressWarnings("unchecked")
            List<byte[]> imgs = (ArrayList<byte[]>)request.getSession().getAttribute("imgs");

            String imgdir = request.getSession().getServletContext().getRealPath("/image");

            productService.addProduct(productEntity,imgs,imgdir);
            request.getSession().removeAttribute("imgs");
        }

         return "{\"status\":1}";
    }

}

class adminBean{

    private int pid;
    private String name;
    private String name2;
    private Double oldprice;
    private Double price;
    private Timestamp date;
    private String status;
    private int sales;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}

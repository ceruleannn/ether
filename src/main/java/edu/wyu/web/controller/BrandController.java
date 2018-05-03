package edu.wyu.web.controller;

import com.alibaba.fastjson.JSON;
import edu.wyu.domain.SysBrandEntity;
import edu.wyu.domain.SysTypeEntity;
import edu.wyu.domain.UserEntity;
import edu.wyu.service.BrandService;
import edu.wyu.service.TypeService;
import org.springframework.stereotype.Controller;
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


@Controller
@RequestMapping("/b")
public class BrandController {

    private BrandService brandService;

    public BrandService getBrandService() {
        return brandService;
    }

    @Inject
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public String list(HttpServletRequest request){

        return "{\"data\":"+JSON.toJSONString(brandService.list())+"}";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request, HttpServletResponse response){

        String action = request.getParameter("action");
        if ("start".equals(action)){
            String bid = request.getParameter("bid");
            brandService.start(bid);
        }
        else if ("stop".equals(action)){
            String bid = request.getParameter("bid");
            brandService.stop(bid);
        }
        else if ("update".equals(action)){

            SysBrandEntity brandEntity = new SysBrandEntity();
            brandEntity.setBid(Integer.parseInt(request.getParameter("bid")));
            brandEntity.setName(request.getParameter("name"));
            brandEntity.setRegion(request.getParameter("region"));
            brandEntity.setDetail(request.getParameter("detail"));
            brandEntity.setStatus(request.getParameter("status"));

            brandService.update(brandEntity);

        }
        else if ("delete".equals(action)){
            String bid = request.getParameter("bid");
            brandService.delete(bid);
        }
        else if ("add".equals(action)){
            SysBrandEntity brandEntity = new SysBrandEntity();

            String icon = request.getParameter("src");
            String dir = request.getSession().getServletContext().getRealPath("/");
            File pic = new File(dir+icon);
            System.out.println(pic.getAbsolutePath());
            if (!pic.exists()){
                return null;
            }

            brandEntity.setName(request.getParameter("name"));
            brandEntity.setRegion(request.getParameter("region"));
            brandEntity.setIcon(icon);
            brandEntity.setDetail(request.getParameter("detail"));
            brandEntity.setStatus(request.getParameter("status"));
            brandEntity.setDate(new Timestamp(System.currentTimeMillis()));

            brandService.addBrand(brandEntity);
        }

        return null;
    }


    @RequestMapping("/logoUpload")
    @ResponseBody
    public String fileUpload(HttpServletRequest request,
                             @RequestParam("filedata") MultipartFile file) throws Exception {

        System.out.println("access logo ");

        if (file==null){
            return null;
        }

        try {
            String uploadDir = request.getSession().getServletContext().getRealPath("/image");

            File image = new File(uploadDir);
            if (!image.exists()) {
                image.mkdirs();
            }

            File logo = new File(image,"logo");
            if (!logo.exists()) {
                logo.mkdirs();
            }

            String name = file.getOriginalFilename();
            request.getSession().setAttribute("logo",file);
            file.transferTo(new File(uploadDir + "/logo/" + name));
            return "{\"path\":\"/image/logo/"+name+"\"}";

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}

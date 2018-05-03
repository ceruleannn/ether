package edu.wyu.web.controller;

import com.alibaba.fastjson.JSON;
import edu.wyu.domain.SysTypeEntity;
import edu.wyu.domain.UserEntity;
import edu.wyu.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/t")
public class TypeController {

    private TypeService typeService;

    public TypeService getTypeService() {
        return typeService;
    }

    @Inject
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public String list(HttpServletRequest request){

        return "{\"data\":"+JSON.toJSONString(typeService.list())+"}";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request){

        String action = request.getParameter("action");
        if ("start".equals(action)){
            String tid = request.getParameter("tid");
            typeService.start(tid);
        }
        else if ("stop".equals(action)){
            String tid = request.getParameter("tid");
            typeService.stop(tid);
        }
        else if ("update".equals(action)){
            SysTypeEntity typeEntity = new SysTypeEntity();
            typeEntity.setTid(Integer.parseInt(request.getParameter("tid")));
            typeEntity.setName(request.getParameter("name"));
            typeEntity.setDetail(request.getParameter("detail"));
            typeEntity.setStatus(request.getParameter("status"));

            typeService.update(typeEntity);
        }
        else if ("delete".equals(action)){
            String tid = request.getParameter("tid");
            typeService.delete(tid);
        }
        else if ("add".equals(action)){
            SysTypeEntity typeEntity = new SysTypeEntity();
            typeEntity.setName(request.getParameter("name"));
            typeEntity.setDetail(request.getParameter("detail"));
            typeEntity.setStatus(request.getParameter("status"));
            typeService.addType(typeEntity);
        }

        return null;
    }

}

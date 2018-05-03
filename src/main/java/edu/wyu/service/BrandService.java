package edu.wyu.service;

import edu.wyu.dao.BrandDao;
import edu.wyu.dao.TypeDao;
import edu.wyu.domain.SysBrandEntity;
import edu.wyu.domain.SysTypeEntity;
import edu.wyu.domain.UserEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service("BrandService")
public class BrandService {
    private BrandDao brandDao;

    public BrandDao getBrandDao() {
        return brandDao;
    }

    @Inject
    public void setBrandDao(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    public List<SysBrandEntity> list(){
        return brandDao.listAll();
    }

    public void start(String tid){
        SysBrandEntity type = brandDao.get(tid);
        type.setStatus("启用");
        brandDao.update(type);
    }
    public void stop(String tid){
        SysBrandEntity type = brandDao.get(tid);
        type.setStatus("停用");
        brandDao.update(type);
    }

    public void update(SysBrandEntity brandEntity){
        SysBrandEntity old = brandDao.get(brandEntity.getBid());
        old.setName(brandEntity.getName());
        old.setRegion(brandEntity.getRegion());
        old.setDetail(brandEntity.getDetail());
        old.setStatus(brandEntity.getStatus());
        brandDao.update(old);
    }

    public void delete(String tid) {
        brandDao.delete(Integer.parseInt(tid));
    }

    public void addBrand(SysBrandEntity brandEntity) {
        brandDao.add(brandEntity);
    }
}

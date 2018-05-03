package edu.wyu.service;

import edu.wyu.dao.TypeDao;
import edu.wyu.domain.SysTypeEntity;
import edu.wyu.domain.UserEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service("TypeService")
public class TypeService {
    private TypeDao typeDao;

    public TypeDao getTypeDao() {
        return typeDao;
    }

    @Inject
    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public List<SysTypeEntity> list(){
        return typeDao.listAll();
    }

    public void start(String tid){
        SysTypeEntity type = typeDao.get(tid);
        type.setStatus("启用");
        typeDao.update(type);
    }
    public void stop(String tid){
        SysTypeEntity type = typeDao.get(tid);
        type.setStatus("停用");
        typeDao.update(type);
    }

    public void update(SysTypeEntity sysTypeEntity){
        SysTypeEntity old = typeDao.get(sysTypeEntity.getTid());
        old.setName(sysTypeEntity.getName());
        old.setDetail(sysTypeEntity.getDetail());
        old.setStatus(sysTypeEntity.getStatus());

        typeDao.update(old);
    }

    public void delete(String tid) {
        typeDao.delete(Integer.parseInt(tid));
    }

    public void addType(SysTypeEntity typeEntity) {
        typeDao.add(typeEntity);
    }
}

package edu.wyu.dao;

import edu.wyu.domain.SysTypeEntity;
import edu.wyu.domain.UserEntity;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TypeDao")
public class TypeDao extends BaseDao<SysTypeEntity>{
    public List<SysTypeEntity> listAll() {
        return this.list("from SysTypeEntity as t");
    }


}

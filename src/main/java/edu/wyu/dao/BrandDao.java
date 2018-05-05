package edu.wyu.dao;

import edu.wyu.domain.SysBrandEntity;
import edu.wyu.domain.SysTypeEntity;
import edu.wyu.domain.UserEntity;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("BrandDao")
public class BrandDao extends BaseDao<SysBrandEntity>{
    public List<SysBrandEntity> listAll() {
        return this.list("from SysBrandEntity as b");
    }


}


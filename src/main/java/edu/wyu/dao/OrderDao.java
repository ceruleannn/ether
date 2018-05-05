package edu.wyu.dao;

import edu.wyu.domain.OrderEntity;
import edu.wyu.util.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 *
 */
@Repository("OrderDao")
public class OrderDao extends BaseDao<OrderEntity>{

    public List<OrderEntity> listByUid(String uid){

        if (uid==null){
            return null;
        }

        if (!StringUtils.isInteger(uid)){
            return null;
        }

        return this.list("from OrderEntity as o join fetch o.user u join fetch o.details where u.uid = ?",Integer.parseInt(uid));
    }

    public List<OrderEntity> listByStatus(String status) {

        if (status==null){
            return null;
        }


        String hql = "select distinct o from OrderEntity as o ";

        if (!status.trim().equals("all")){
            hql += " where o.status = ?";
            return this.list(hql,status.trim());
        }
        return this.list(hql);

    }
}

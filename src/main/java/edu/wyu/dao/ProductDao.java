package edu.wyu.dao;

import edu.wyu.domain.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 *
 */
@Repository("ProductDao")
public class ProductDao extends BaseDao<ProductEntity>{

    public ProductEntity getProductByID(int id){
        ProductEntity product = this.load(id);
        return product;
    }

    public List<ProductEntity> productList(String tid, String bid) {

        if (tid==null){
            return null;
        }

        String hql = "from Product as p join fetch p.type t ";

        if (bid!=null){
            hql += "join fetch p.brand b where t.tid = ? and b.bid = ? order by sales desc";
            return this.list(hql,tid,bid);
        }

        hql += "where t.tid = ? order by sales desc";
        return this.list(hql,tid);
    }
}

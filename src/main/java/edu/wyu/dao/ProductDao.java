package edu.wyu.dao;

import edu.wyu.domain.ProductEntity;
import edu.wyu.util.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public List<ProductEntity> productList(String tid, String bid, String order) {

        return this.productList(tid,bid,order,null,null,null);

    }

    public List<ProductEntity> productList(String tid, String bid, String order, String price1, String price2, String limit) {
        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<>(5);

        sb.append("from ProductEntity as p ");

        if (StringUtils.notEmpty(tid)){
            sb.append(" join fetch p.type t ");
        }

        if (StringUtils.notEmpty(bid)){
            sb.append(" join fetch p.brand b ");
        }

        sb.append(" where 1=1 ");

        if (StringUtils.notEmpty(tid)){
            if (!tid.equals("all")){
                sb.append(" and t.tid = ? ");
                list.add(Integer.parseInt(tid));
            }
        }

        if (StringUtils.notEmpty(bid)){
            if (!bid.equals("all")){
                sb.append(" and b.bid = ? ");
                list.add(Integer.parseInt(bid));
            }
        }

        if (StringUtils.notEmpty(price1)&&StringUtils.notEmpty(price2)){
            Integer p1 = Integer.parseInt(price1);
            Integer p2 = Integer.parseInt(price2);
            if (p1<p2){
                sb.append("and price > ? and price < ? ");
                list.add(p1);
                list.add(p2);
            }
        }

        sb.append("order by ");

        if (StringUtils.notEmpty(order)){
            sb.append("sales desc ");
        }else{

            switch (order) {
                case "priceAsc":
                    sb.append("price asc ");
                    break;
                case "priceDesc":
                    sb.append("price desc ");
                    break;
                case "time":
                    sb.append("p.date desc ");
                    break;
                default:
                    sb.append("sales desc ");
                    break;
            }
        }

        if (StringUtils.notEmpty(limit)){
            sb.append("limit ?,15");
            list.add(Integer.parseInt(limit));
        }

        System.out.println("sql:"+sb.toString());
        return this.list(sb.toString(),list.toArray(new Object[list.size()]));

    }

}

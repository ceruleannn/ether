package edu.wyu.dao;

import edu.wyu.domain.ProductEntity;
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

        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<>(2);

        sb.append("from ProductEntity as p ");

        if (tid!=null){
            sb.append(" join fetch p.type t ");
        }

        if (bid!=null){
            sb.append(" join fetch p.brand b ");
        }

        sb.append(" where 1=1 ");

        if (tid!=null){
            if (!tid.equals("all")){
                sb.append(" and t.tid = ? ");
                list.add(Integer.parseInt(tid));
            }
        }

        if (bid!=null){
            if (!bid.equals("all")){
                sb.append(" and b.bid = ? ");
                list.add(Integer.parseInt(bid));
            }
        }

        sb.append(" order by ");

        if (order==null){
            sb.append("sales desc");
        }else{

            switch (order) {
                case "price":
                    sb.append("price asc");
                    break;
                case "sales":
                    sb.append("sales asc");
                    break;
                case "time":
                    sb.append("p.date asc");
                    break;
                case "price2":
                    sb.append("price desc");
                    break;
                case "time2":
                    sb.append("p.date desc");
                    break;
                default:
                    sb.append("sales desc");
                    break;
            }
        }

        System.out.println("sql:"+sb.toString());
        return this.list(sb.toString(),list.toArray(new Object[list.size()]));

    }
}

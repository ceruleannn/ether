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

        if (tid==null){
            return null;
        }

        List<Object> list = new ArrayList<>(2);
        list.add(Integer.parseInt(tid));

        StringBuilder sb = new StringBuilder();
        sb.append("from ProductEntity as p join fetch p.type t ");

        if (bid!=null){
           sb.append(" join fetch p.brand b where t.tid = ? ");
           if (!bid.equals("all")){
               sb.append(" and b.bid = ? ");
               list.add(Integer.parseInt(bid));
           }
        }
        else {
            sb.append("where t.tid = ?");
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
                    sb.append("date asc");
                    break;
                case "price2":
                    sb.append("price desc");
                    break;
                case "time2":
                    sb.append("date desc");
                    break;
                default:
                    sb.append("sales desc");
                    break;
            }
        }


        return this.list(sb.toString(),list.toArray(new Object[list.size()]));

    }
}

package edu.wyu.service;

import edu.wyu.dao.ProductDao;
import edu.wyu.domain.ProductEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 *
 *
 *
 */
@Service("ProductService")
public class ProductService {

    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    @Inject
    public void setProductDao(ProductDao dao) {
        this.productDao = dao;
    }

    public ProductEntity getProductByID(int id){
        return productDao.getProductByID(id);
    }

    public List<ProductEntity> list(String tid, String bid) {
        return productDao.productList(tid,bid);
    }
}

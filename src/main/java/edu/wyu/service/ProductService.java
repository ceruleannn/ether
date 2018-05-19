package edu.wyu.service;

import edu.wyu.dao.ProductDao;
import edu.wyu.domain.ProductEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

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

    public List<ProductEntity> list(String tid, String bid, String order) {
        return productDao.productList(tid,bid,order);
    }

    public void start(String pid){
        ProductEntity product = productDao.get(pid);
        product.setStatus("启用");
        productDao.update(product);
    }
    public void stop(String pid){
        ProductEntity product = productDao.get(pid);
        product.setStatus("停用");
        productDao.update(product);
    }

    public void delete(String pid) {
        productDao.delete(Integer.parseInt(pid));
    }

    public void addProduct(ProductEntity productEntity, List<byte[]> imgs, String imgdir) {

        File image = new File(imgdir);
        if (!image.exists()) {
            image.mkdirs();
        }

        File productPic = new File(image,"productPic");
        if (!productPic.exists()) {
            productPic.mkdirs();
        }

        try {

            Class<ProductEntity> clazz = ProductEntity.class;
            String uuid = UUID.randomUUID().toString();
            for (int i=0;i<imgs.size()&&i<=3;i++) {

                String path = imgdir+"/productPic/"+ uuid+"_"+i+".jpg";
                System.out.println(path);

                File file = new File(path);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(imgs.get(i));

                Method method = clazz.getMethod("setPic"+(i+1),String.class);
                method.invoke(productEntity,"/image/productPic/"+ uuid+"_"+i+".jpg");
            }
            System.out.println(productEntity);
            productDao.add(productEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProductEntity> list(String tid, String bid, String order, String price1, String price2, String limit) {
        return productDao.productList(tid,bid,order,price1,price2,limit);
    }
}

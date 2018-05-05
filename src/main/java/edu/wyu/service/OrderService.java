package edu.wyu.service;

import edu.wyu.dao.OrderDao;
import edu.wyu.domain.OrderEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 *
 *
 *
 */
@Service("OrderService")
public class OrderService {

    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    @Inject
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<OrderEntity> listByUid(String uid)
    {
        return orderDao.listByUid(uid);
    }
    public List<OrderEntity> listByStatus(String status){

        return orderDao.listByStatus(status);
    }

    public void deliver(String oid, String deliverCompany, String deliverid) {

        OrderEntity orderEntity = orderDao.get(oid);
        orderEntity.setDeliverCompany(deliverCompany);
        orderEntity.setDeliverid(Integer.parseInt(deliverid));
        orderEntity.setStatus("待收货");

        orderDao.update(orderEntity);

    }

    public void delete(String oid) {

        orderDao.delete(Integer.parseInt(oid));
    }

    public void gotProduct(OrderEntity orderEntity) {
        orderEntity.setStatus("已完成");
        orderDao.update(orderEntity);
    }
}

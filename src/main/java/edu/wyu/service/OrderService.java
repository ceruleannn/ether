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

    public List<OrderEntity> listByUid(String uid){
        return orderDao.listByUid(uid);
    }
}

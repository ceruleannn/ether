package edu.wyu.service;

import edu.wyu.dao.UserDao;
import edu.wyu.domain.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 *
 *
 *
 */
@Service("UserService")
public class UserService {

    private UserDao userDao;

    @Inject
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> list(){
        return userDao.list();
    }

    public User register(String phone,String password){

        //TODO VALIDATE PHONE AND PASSWORD
        if (userDao.checkPhone(phone)){

           return null; //failed
        }
        User user = new User(phone,password);
        userDao.register(user);

        return user;
    }

    public User login(String phone,String password){
        return userDao.login(phone,password);
    }

    public User editPassword(String phone,String password){
        return userDao.editPassword(phone,password);
    }
}

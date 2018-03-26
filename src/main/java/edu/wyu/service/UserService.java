package edu.wyu.service;

import edu.wyu.dao.UserDao;
import edu.wyu.domain.UserEntity;
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

    public List<UserEntity> list(){
        return userDao.list();
    }

    public boolean register(UserEntity user){

        //TODO VALIDATE PHONE AND PASSWORD
        if (userDao.checkPhoneExist(user.getPhone())){

           return false; //failed
        }
        userDao.register(user);

        return true;
    }

    public UserEntity login(String phone,String password){
        return userDao.login(phone,password);
    }

    public UserEntity editPassword(String phone,String password){
        return userDao.editPassword(phone,password);
    }

    public boolean checkPhoneExist(String phone){
        return userDao.checkPhoneExist(phone);
    }
}

package edu.wyu.dao;

import edu.wyu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Repository("UserDao")
public class UserDao extends BaseDao<User>{

    public List<User> list() {
        String hql = "from User ";

        return this.list(hql, null);
    }

    /**
     *
     * @param phone
     * @param password
     * @return the user that login successfully or null if failed
     */
    public User login(String phone, String password){
        String hql = "from User where phone = ? and password = ?";

        return this.list(hql, phone, password).get(0);
    }

    /**
     *
     * @param phone
     * @return true if exist
     */
    public boolean checkPhone(String phone){
        String hql = "from User where phone = ? ";
        int size = list(hql,phone).size();
        return size>0;
    }

    public void register(User user){
        this.add(user);
    }

    public User editPassword(String phone , String password){
        User user = queryUserByPhone(phone);
        user.setPassword(password);
        this.update(user);
        return user;
    }

    public User queryUserByPhone(String phone){
        String hql = "from User where phone = ? ";
        List<User> users = this.list(hql,phone);
        if (users.size()==1){
            return users.get(0);
        }
        return null;
    }

}

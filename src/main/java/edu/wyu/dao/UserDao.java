package edu.wyu.dao;

import edu.wyu.domain.UserEntity;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("UserDao")
public class UserDao extends BaseDao<UserEntity>{

    public List<UserEntity> list() {
        String hql = "from UserEntity ";

        return this.list(hql, null);
    }

    /**
     *
     * @param phone
     * @param password
     * @return the user that login successfully or null if failed
     */
    public UserEntity login(String phone, String password){
        String hql = "from UserEntity where phone = ? and password = ?";

        List<UserEntity> list = this.list(hql, phone, password);
        return list.size()==0?null:list.get(0);
    }

    /**
     *
     * @param phone
     * @return true if exist
     */
    public boolean checkPhoneExist(String phone){
        String hql = "from UserEntity where phone = ? ";
        int size = list(hql,phone).size();
        return size>0;
    }

    public void register(UserEntity user){
        this.add(user);
    }

    public UserEntity editPassword(String phone , String password){
        UserEntity user = queryUserByPhone(phone);
        if (user==null){
            return null;
        }
        user.setPassword(password);
        this.update(user);
        return user;
    }

    public UserEntity queryUserByPhone(String phone){
        String hql = "from UserEntity where phone = ? ";
        List<UserEntity> users = this.list(hql,phone);
        if (users.size()==1){
            return users.get(0);
        }
        return null;
    }

    @Override
    public UserEntity get(Serializable id) {
        if (id instanceof String){
            id = Integer.parseInt((String)(id));
        }

        if (id instanceof Integer){
            return super.get(id);
        }
        return null;
    }
}

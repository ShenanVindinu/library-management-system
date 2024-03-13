package lk.ijse.dao.custom;

import lk.ijse.entity.User;

public interface SignupDAO {

    Long existUsername(String userName);
    void save(User user);

}

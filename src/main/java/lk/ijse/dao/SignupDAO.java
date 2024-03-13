package lk.ijse.dao;

import lk.ijse.entity.User;

public interface SignupDAO {

    Long existUsername(String userName);
    void save(User user);

}

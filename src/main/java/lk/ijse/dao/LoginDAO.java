package lk.ijse.dao;

import lk.ijse.entity.User;

public interface LoginDAO {

    User getUserNamePassword(String userName, String password);


}

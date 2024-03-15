package lk.ijse.dao.custom;

import lk.ijse.entity.User;

public interface LoginDAO {

    User getUserNamePassword(String userName, String password);

    User getUserName(String username);


}

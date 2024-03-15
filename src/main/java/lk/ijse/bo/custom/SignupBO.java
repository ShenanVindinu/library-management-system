package lk.ijse.bo.custom;

import lk.ijse.entity.User;

public interface SignupBO {

    Long checkIfUserNameExist(String userName);
    void saveUser(User user);
    void updateUser(User user,String password);

}

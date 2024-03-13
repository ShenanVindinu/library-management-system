package lk.ijse.bo;

import lk.ijse.entity.User;

public interface SignupBO {

    Long checkIfUserNameExist(String userName);
    void saveUser(User user);

}

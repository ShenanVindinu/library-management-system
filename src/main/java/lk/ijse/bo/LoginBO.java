package lk.ijse.bo;

import lk.ijse.entity.User;

public interface LoginBO {

    User signIn(String userName, String password);

}

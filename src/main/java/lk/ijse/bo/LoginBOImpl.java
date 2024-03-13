package lk.ijse.bo;

import lk.ijse.dao.LoginDAOImpl;
import lk.ijse.entity.User;

public class LoginBOImpl {

    public User signIn(String userName, String password) {
        LoginDAOImpl loginDAO = new LoginDAOImpl();
        User user = loginDAO.getUserNamePassword(userName,password);

        return user;
    }

}

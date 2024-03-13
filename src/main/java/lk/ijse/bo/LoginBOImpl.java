package lk.ijse.bo;

import lk.ijse.dao.custom.LoginDAO;
import lk.ijse.dao.custom.impl.LoginDAOImpl;
import lk.ijse.entity.User;

public class LoginBOImpl {

    LoginDAO loginDAO = new LoginDAOImpl();

    public User signIn(String userName, String password) {
        return loginDAO.getUserNamePassword(userName,password);
    }

}

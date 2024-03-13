package lk.ijse.bo;

import lk.ijse.dao.LoginDAO;
import lk.ijse.dao.LoginDAOImpl;
import lk.ijse.entity.User;

public class LoginBOImpl {

    LoginDAO loginDAO = new LoginDAOImpl();

    public User signIn(String userName, String password) {
        return loginDAO.getUserNamePassword(userName,password);
    }

}

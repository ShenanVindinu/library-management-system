package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.LoginBO;
import lk.ijse.dao.custom.LoginDAO;
import lk.ijse.dao.custom.impl.LoginDAOImpl;
import lk.ijse.entity.User;

public class LoginBOImpl implements LoginBO {

    LoginDAO loginDAO = new LoginDAOImpl();

    @Override
    public User signIn(String userName, String password) {
        return loginDAO.getUserNamePassword(userName,password);
    }

}

package lk.ijse.bo;

import lk.ijse.dao.SignupDAO;
import lk.ijse.entity.User;

public class SignupBO {

    SignupDAO signupDAO = new SignupDAO();

    public Long checkIfUserNameExist(String userName) {
        Long value  = signupDAO.existUsername(userName);
        return value;
    }

    public void saveUser(User user) {
        signupDAO.save(user);
    }

}

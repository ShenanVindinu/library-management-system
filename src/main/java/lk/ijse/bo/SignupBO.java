package lk.ijse.bo;

import lk.ijse.dao.SignupDAO;
import lk.ijse.dao.SignupDAOImpl;
import lk.ijse.entity.User;

public class SignupBO {

    SignupDAO signupDAOImpl = new SignupDAOImpl();

    public Long checkIfUserNameExist(String userName) {
        return signupDAOImpl.existUsername(userName);
    }

    public void saveUser(User user) {
        signupDAOImpl.save(user);
    }

}

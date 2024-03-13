package lk.ijse.bo;

import lk.ijse.dao.SignupDAOImpl;
import lk.ijse.entity.User;

public class SignupBO {

    SignupDAOImpl signupDAOImpl = new SignupDAOImpl();

    public Long checkIfUserNameExist(String userName) {
        Long value  = signupDAOImpl.existUsername(userName);
        return value;
    }

    public void saveUser(User user) {
        signupDAOImpl.save(user);
    }

}

package lk.ijse.bo;

import lk.ijse.dao.custom.SignupDAO;
import lk.ijse.dao.custom.impl.SignupDAOImpl;
import lk.ijse.entity.User;

public class SignupBOImpl {

    SignupDAO signupDAOImpl = new SignupDAOImpl();

    public Long checkIfUserNameExist(String userName) {
        return signupDAOImpl.existUsername(userName);
    }

    public void saveUser(User user) {
        signupDAOImpl.save(user);
    }

}

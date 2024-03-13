package lk.ijse.bo;

import lk.ijse.dao.custom.SignupDAO;
import lk.ijse.dao.custom.impl.SignupDAOImpl;
import lk.ijse.entity.User;

public class SignupBOImpl implements SignupBO {

    SignupDAO signupDAOImpl = new SignupDAOImpl();

    @Override
    public Long checkIfUserNameExist(String userName) {
        return signupDAOImpl.existUsername(userName);
    }

    @Override
    public void saveUser(User user) {
        signupDAOImpl.save(user);
    }

}

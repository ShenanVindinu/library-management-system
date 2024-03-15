package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SignupBO;
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

    @Override
    public void updateUser(User user,String password) {
        signupDAOImpl.update(user,password);
    }

}

package lk.ijse.bo.custom.impl;

import lk.ijse.dao.custom.impl.UserProfileDAOImpl;
import lk.ijse.entity.BookHistory;

public class UserProfileBOImpl {

    UserProfileDAOImpl userProfileDAO = new UserProfileDAOImpl();

    public void addToBookHistory(BookHistory bookHistory) {
        userProfileDAO.add(bookHistory);
    }
}

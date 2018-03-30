package xxxxxx.yyyyyy.zzzzzz.domain.service.user;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import xxxxxx.yyyyyy.zzzzzz.domain.model.User;

public class UserServiceImpl{

    @Autowired
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user){
        getUserDAO().insert(user);
    }
    public List<User> fetchAllStudents() {
        return getUserDAO().selectAll();
    }

}

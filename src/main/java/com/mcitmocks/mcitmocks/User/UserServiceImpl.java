package com.mcitmocks.mcitmocks.User;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDaoParam){
        this.userDao=userDaoParam;
    }

    @Override
    @Transactional
    public User addUser(User user){
        return userDao.addUser(user);
    }
}

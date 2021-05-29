package com.mcitmocks.mcitmocks.User;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactoryParam){
        this.sessionFactory= sessionFactoryParam;
    }
    @Override
    public User addUser(User user) {
        Session currentSession = sessionFactory.openSession();
        currentSession.persist(user);
        logger.info("User saved successfully, User Details="+user);
        return user;
    }
}

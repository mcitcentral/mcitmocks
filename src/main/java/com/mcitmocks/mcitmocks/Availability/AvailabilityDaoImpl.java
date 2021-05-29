package com.mcitmocks.mcitmocks.Availability;

import com.mcitmocks.mcitmocks.User.User;
import com.mcitmocks.mcitmocks.User.UserDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AvailabilityDaoImpl implements AvailabilityDao{
    private static final Logger logger = LoggerFactory.getLogger(AvailabilityDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    /*public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }*/
    @Override
    @Transactional
    public List<Availability> getAvailabilityResponse() {
            Session currentSession = sessionFactory.openSession();
            Query<Availability> theQuery =
                    currentSession.createQuery("from Availability", Availability.class);
            List<Availability> availabilities = theQuery.getResultList();
            logger.info("retrieved availability");
            return availabilities;

    }


}

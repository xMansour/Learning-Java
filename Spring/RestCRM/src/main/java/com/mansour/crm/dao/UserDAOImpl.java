package com.mansour.crm.dao;

import com.mansour.crm.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from User order by firstName", User.class)
                .getResultList();
    }

    @Override
    public void addUser(User user) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(user);
    }

    @Override
    public User getUser(int userId) {
        return sessionFactory
                .getCurrentSession()
                .get(User.class, userId);
    }

    @Override
    public void deleteUser(int userId) {
        User user = getUser(userId);
        sessionFactory
                .getCurrentSession()
                .remove(user);
    }
}

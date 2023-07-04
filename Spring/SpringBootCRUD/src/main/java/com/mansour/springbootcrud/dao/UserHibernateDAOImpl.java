package com.mansour.springbootcrud.dao;

import com.mansour.springbootcrud.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserHibernateDAOImpl implements UserDAO {
    private EntityManager entityManager;

    @Autowired
    public UserHibernateDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers() {
        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("from User ", User.class);
        return query.getResultList();

    }

    @Override
    public User getUser(int userId) {
        return entityManager.unwrap(Session.class).get(User.class, userId);
    }

    @Override
    public void addUser(User user) {
        entityManager.unwrap(Session.class).persist(user);
    }

    @Override
    public void removeUser(int userId) {
        User user = getUser(userId);
        entityManager.unwrap(Session.class).remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
    }
}

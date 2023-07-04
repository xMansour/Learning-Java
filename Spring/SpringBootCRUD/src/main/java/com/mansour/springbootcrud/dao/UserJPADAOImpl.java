package com.mansour.springbootcrud.dao;

import com.mansour.springbootcrud.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserJPADAOImpl implements UserDAO{
    private EntityManager entityManager;

    @Autowired
    public UserJPADAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUser(int userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(int userId) {
        entityManager.remove(getUser(userId));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}

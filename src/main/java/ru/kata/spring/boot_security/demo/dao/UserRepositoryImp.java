package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select distinct a from User a left join fetch a.roles", User.class).getResultList();
    }

    //Добавление user
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    //перезаписать user
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    //Удаление user
    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByUsername(String username) {
        return entityManager.createQuery("select distinct a from User a left join fetch a.roles where a.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }
}

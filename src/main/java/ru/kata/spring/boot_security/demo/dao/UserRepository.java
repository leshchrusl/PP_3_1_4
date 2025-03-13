package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;


public interface UserRepository {

    public List<User> getAllUsers();
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(long id);
    public User getUserById(long id);
    public User findUserByUsername(String username);
}

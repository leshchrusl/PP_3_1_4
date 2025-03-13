package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(long id);
    public void deleteUserById(long id);
    public void saveUser(User user);
    public void updateUser(User user);
    public User findUserByUsername(String username);
}

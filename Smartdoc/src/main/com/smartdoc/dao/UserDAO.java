package main.com.smartdoc.dao;


import main.com.smartdoc.model.User;

public interface UserDAO extends DAO<User> {
    User getUserByUsername(String username);
}
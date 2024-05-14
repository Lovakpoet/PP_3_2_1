package org.example.pp312last.service;


import org.example.pp312last.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findAll();

    void update(User user);

    void delete(long id);

    User show(long id);
}

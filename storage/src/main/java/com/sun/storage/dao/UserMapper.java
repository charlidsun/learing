package com.sun.storage.dao;

import java.util.List;

import com.sun.storage.domain.User;

public interface UserMapper {

	List<User> getUsers();

    int addUser(User user);

    List<User> getUsersByName( String userName );
}

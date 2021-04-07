package com.philocalist.philocalistwebsite.dao;

import com.philocalist.philocalistwebsite.model.authentication.User;
import com.philocalist.philocalistwebsite.model.authentication.UserRoleChange;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User getUserById(Long userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

    public void updateUserRole(UserRoleChange user);

    public void deleteUserById(long id);
}

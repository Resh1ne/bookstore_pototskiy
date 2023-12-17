package com.belhard.bookstore.data;

import com.belhard.bookstore.data.entity.User;

import java.util.List;

public interface UserDao {
    User create(User user);

    User findById(Long id);

    List<User> findAll();

    User update(User user);

    boolean delete(Long id);

    User findByEmail(String email);

    List<User> findByLastName(String lastName);

    long countAll();
}

package com.belhard.bookstore;

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

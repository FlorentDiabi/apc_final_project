package org.amu.repository;

import org.amu.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByRole(String role);
}

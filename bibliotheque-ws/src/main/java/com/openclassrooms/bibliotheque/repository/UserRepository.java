package com.openclassrooms.bibliotheque.repository;

import com.openclassrooms.bibliotheque.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByNameAndPassword(String name, String password);
}

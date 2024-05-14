package org.example.pp312last.repository;


import org.example.pp312last.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
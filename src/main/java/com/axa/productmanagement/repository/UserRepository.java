package com.axa.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.axa.productmanagement.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}



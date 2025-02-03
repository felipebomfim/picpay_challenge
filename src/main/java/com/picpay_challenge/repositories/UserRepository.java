package com.picpay_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay_challenge.domain.user.User;
import java.util.Optional;
import java.util.List;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByDocument(String document);

    Optional<User> findById(Long id);
}

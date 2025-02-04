package com.example.desafiobackenditarc.repository;

import com.example.desafiobackenditarc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByCityName(String cityName);
}

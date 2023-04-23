package com.product.Backend_Solar.Repository;

import com.product.Backend_Solar.Entity.Users;
import com.product.Backend_Solar.UsersDTO.UsersDTO;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}

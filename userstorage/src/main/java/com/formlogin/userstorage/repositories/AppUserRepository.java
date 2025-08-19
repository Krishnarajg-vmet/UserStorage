package com.formlogin.userstorage.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formlogin.userstorage.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	Optional<AppUser> findByUsername(String username);
}

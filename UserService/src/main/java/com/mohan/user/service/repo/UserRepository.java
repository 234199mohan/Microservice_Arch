package com.mohan.user.service.repo;

import com.mohan.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>
{
}

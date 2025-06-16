package com.lcs.finsight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcs.finsight.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

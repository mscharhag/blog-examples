package com.mscharhag.springjooq.repository;

import com.mscharhag.springjooq.jooq.JooqQueryExecutor;
import com.mscharhag.springjooq.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JooqQueryExecutor<User> {

	User findUserByName(String name);
}

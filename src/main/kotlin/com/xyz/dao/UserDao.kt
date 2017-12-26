package com.xyz.dao

import com.xyz.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface UserDao : CrudRepository<User, Long> {
    fun findByEmail(email: String): User?
}

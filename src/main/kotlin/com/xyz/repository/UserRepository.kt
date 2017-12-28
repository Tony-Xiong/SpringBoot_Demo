package com.xyz.repository

import com.xyz.entity.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

@Transactional
interface UserRepository : CrudRepository<User, Long> {
    fun findByEmail(email: String): User?

    @Query("select * from user where user = :name and passwd = :passwd",nativeQuery = true)
    fun checkUser(@Param("name") name: String,@Param("passwd") passwd :String) : MutableList<User>
}

package com.xyz.repository

import com.xyz.entity.Users
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

@Transactional
interface UserRepository : CrudRepository<Users, Long> {
    fun findByLoginName(username: String): Users?


    @Query("select * from user where user = :name and passwd = :passwd",nativeQuery = true)
    fun checkUser(@Param("name") name: String,@Param("passwd") passwd :String) : MutableList<Users>
}

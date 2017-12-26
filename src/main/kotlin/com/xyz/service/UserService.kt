package com.xyz.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.xyz.service.dao.UserDao
import com.xyz.entity.User
import org.springframework.transaction.annotation.Transactional


@Service
 class UserService  {

    @Autowired
    val userDao : UserDao? = null

    @Transactional
    fun saveUser(userIn : User) {
        userDao?.save(userIn)
    }

}

package com.xyz.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.xyz.dao.UserDao
import com.xyz.entity.User
import org.springframework.transaction.annotation.Transactional


@Service
 class UserService  {

    @Autowired
    lateinit var  userDao : UserDao

    @Transactional
    fun saveUser(userIn : User) {
        userDao.save(userIn)
    }

}

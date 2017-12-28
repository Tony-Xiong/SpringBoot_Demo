package com.xyz.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.xyz.repository.UserRepository
import com.xyz.entity.User
import org.springframework.transaction.annotation.Transactional


@Service
 class UserService  {

    @Autowired
    lateinit var userRepository: UserRepository

    @Transactional
    fun saveUser(userIn : User) : Boolean {
        try {
            userRepository.save(userIn)
            return true
        }
        catch (e : Exception ){
            println(e)
        }
        return false
    }

    @Transactional
    fun checkUser(userIn: User) : Boolean{
        val name = userIn.user
        val passwd = userIn.passwd
        return userRepository.checkUser(name, passwd).size == 1
    }

    @Transactional
    fun getAll() : List<User>{
        return userRepository.findAll().toList()
    }
}

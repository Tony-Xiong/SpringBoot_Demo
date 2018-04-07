package com.xyz.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.xyz.repository.UserRepository
import com.xyz.entity.Users
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.transaction.annotation.Transactional



@Service
 class UserService : UserDetailsService  {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String): UserDetails {
        val user : Users = userRepository.findByLoginName(username) ?: error("用户名不存在")
        return user
    }

    @Suppress("UNREACHABLE_CODE")
    @Transactional
    fun saveUser(userIn : Users) : Boolean {
        try {
            userRepository.save(userIn)
            return true
        }
        catch (e : Exception ){
            println(e)
        }
        finally {
            return false
        }
    }

    @Transactional
    fun getUserByUsername(username: String):Users?{
        return userRepository.findByLoginName(username)
    }

    @Transactional
    fun getAll() : List<Users>{
        return userRepository.findAll().toList()
    }
}

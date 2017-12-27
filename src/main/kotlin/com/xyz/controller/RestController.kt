package com.xyz.controller

import com.xyz.service.UserService
import com.xyz.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/REST")
class RestController{

    @Autowired lateinit var userService : UserService

    @RequestMapping("/getAll")
    fun getAll(): List<User> {
        println(test())
        return userService.getAll()
    }

    @Bean
    fun test(): String {
        println("succeed bean")
        return "Hello"
    }
}
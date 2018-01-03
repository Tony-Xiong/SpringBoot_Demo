package com.xyz.controller

import com.xyz.service.UserService
import com.xyz.entity.Users
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
@RequestMapping("/REST")
class RestController{

    @Resource
    var userService : UserService = UserService()

    @RequestMapping("/getAll")
    fun getAll(): List<Users>? {
        println(test())
        println(userService.getAll().toString())
        return userService.getAll()
    }

    @Bean
    fun test(): String {
        println("succeed bean")
        return "Hello"
    }
}
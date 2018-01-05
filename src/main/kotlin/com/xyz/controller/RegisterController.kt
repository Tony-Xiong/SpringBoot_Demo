package com.xyz.controller

import com.xyz.entity.Users
import com.xyz.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.annotation.Resource


@Controller
@RequestMapping("/register")
class RegisterController{
    @Resource
    var userService : UserService = UserService()

    @GetMapping("new")
    fun addUserPage(): String {
        return "register"
    }
    @PostMapping("reg")
    fun addUser(@RequestParam map : HashMap<String,String>) : String{
        val user = Users()
        user.addMap(map)
        return if (userService.saveUser(user)){"regSucceed"}else{"regFailed"}
    }
}
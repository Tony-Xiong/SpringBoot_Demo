package com.xyz.controller

import com.xyz.entity.User
import com.xyz.service.UserService
import com.xyz.service.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
@EnableAutoConfiguration
@ComponentScan(basePackages = ["com.xyz.dao","com.xyz.entity","com.xyz.service","com.xyz.controller"])
class IndexController {

    @Autowired
    lateinit var userService : UserService

    @Autowired val userDao : UserDao? = null

    @RequestMapping("/")
    fun home(m:Model):String{
        m.addAttribute("name","XYZ")
        return "index"
    }

    @RequestMapping("/login")
    fun login(): String {
        return "login"
    }

    @RequestMapping("/welcome",params = ["name","passwd"])
    fun welcome(m: Model,@RequestParam map:HashMap<String,String>): ModelAndView {
        val name = map["name"]
        m.addAttribute("userName",name)
        return ModelAndView("welcome")
    }

    @RequestMapping("/welcome")
    fun welcome(): String {
        return "redirect:/login"
    }

    @RequestMapping("/register")
    fun register(): String {
        return "register"
    }
    @RequestMapping("/registerUser")
    fun user(@RequestParam map:HashMap<String,String>): String {
        println(map.toString())
        var user: User = User()
        val name = map["name"]
        val passwd = map["passwd"]
        val id = map["id"]
        user.user = name!!
        user.passwd = passwd!!
        user.id = id!!
        println("${user.toString()}")
        userService.saveUser(user)
        return "login"
    }
}
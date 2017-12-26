package com.xyz.controller

import com.xyz.entity.User
import com.xyz.service.UserService
import com.xyz.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@EnableAutoConfiguration
@ComponentScan(basePackages = ["com.xyz"])
@EntityScan("com.xyz.entity")
@EnableJpaRepositories("com.xyz.dao")

@Controller
class IndexController {

    @Autowired
    lateinit var userService : UserService

    @Autowired
    lateinit var userDao : UserDao

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
        val id : Int = map["id"]!!.toInt()
        user.user = name!!
        user.passwd = passwd!!
        user.id = id!!
        println("${user.toString()}")
        userService.saveUser(user)
        return "login"
    }
}
package com.xyz.controller

import com.xyz.entity.User
import com.xyz.service.UserService
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


    @RequestMapping("/")
    fun home(m:Model):String{
        m.addAttribute("name","XYZ")
        return "index"
    }

    @RequestMapping("/login")
    fun login(): String {
        return "login"
    }

/*    @RequestMapping("/welcome")
    fun welcome(m: Model,@RequestParam map:HashMap<String,String>): String {
        val name = map["name"]
        m.addAttribute("userName",name)
        return "welcome"
    }*/
    @RequestMapping("/check",params = ["name","passwd"])
    fun checkUser(m: Model,@RequestParam map:HashMap<String,String>): String {
        val user : User = User().toUser(map)
    return if (userService.checkUser(user)){
        m.addAttribute("userName",map["name"])
        "welcome"
    }else {
        "redirect:/login"
    }
    }


    @RequestMapping("/register")
    fun register(): String {
        return "register"
    }
    @RequestMapping("/registerUser")
    fun user(@RequestParam map:HashMap<String,String>): String {
        println(map.toString())
        val user: User = User().toUser(map)
        if(userService.saveUser(user)) {
            return "regSucceed"
        }
        return "register"
    }
}
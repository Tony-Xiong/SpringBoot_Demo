package com.xyz.controller




import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession


//不必要的扫描，之前把index的controller作为主类，所以要加，改过了启动main函数之后，这些都是不必要的扫描
//@EnableAutoConfiguration
//@ComponentScan(basePackages = ["com.xyz"])
//@EntityScan("com.xyz.entity")
//@EnableJpaRepositories("com.xyz.repository")

@Controller
class IndexController {




    @RequestMapping("/")
    fun home(m:Model,session: HttpSession):String{
        m.addAttribute("name","XYZ")
        println(session.toString())
        return "index"
    }

//    @GetMapping("/login")
//    fun login():String{
//        return "login"
//    }
}
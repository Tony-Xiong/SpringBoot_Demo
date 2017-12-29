package com.xyz.controller


import com.xyz.entity.User
import com.xyz.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

//不必要的扫描，之前把index的controller作为主类，所以要加，改过了启动main函数之后，这些都是不必要的扫描
//@EnableAutoConfiguration
//@ComponentScan(basePackages = ["com.xyz"])
//@EntityScan("com.xyz.entity")
//@EnableJpaRepositories("com.xyz.repository")

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

    @RequestMapping("/welcome",method = [RequestMethod.POST,RequestMethod.GET])
    fun welcome(m: Model,@RequestParam map:HashMap<String,String>): String {
        return if (!m.asMap().isEmpty()){
            "welcome"
        }else{ "redirect:/login" }
    }
    @RequestMapping("/check",params = ["name","passwd"])
    fun checkUser(attr: RedirectAttributes,@RequestParam map:HashMap<String,String>): String {
        val user : User = User().toUser(map)
    return if (userService.checkUser(user)){
        val name = map["name"]
        attr.addFlashAttribute("userName",name)
        "redirect:/welcome"

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
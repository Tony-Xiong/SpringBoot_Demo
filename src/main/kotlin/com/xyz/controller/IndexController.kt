package com.xyz.controller


import com.xyz.entity.Article
import com.xyz.entity.Users
import com.xyz.service.ArticleService
import com.xyz.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource
import javax.servlet.http.HttpSession


//不必要的扫描，之前把index的controller作为主类，所以要加，改过了启动main函数之后，这些都是不必要的扫描
//@EnableAutoConfiguration
//@ComponentScan(basePackages = ["com.xyz"])
//@EntityScan("com.xyz.entity")
//@EnableJpaRepositories("com.xyz.repository")

@Controller
class IndexController {

    @Resource
    var userService : UserService = UserService()

    @Resource
    var articleService : ArticleService = ArticleService()

    @RequestMapping("/")
    fun home(m:Model,session: HttpSession):String{
        var list: List<Users> = userService.getAll()
        m.addAttribute("name","XYZ")
        m.addAttribute("users", list)
        m.addAttribute("sum",articleService.findAll().size)
        return "index"
    }

}
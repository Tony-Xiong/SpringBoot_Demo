package com.xyz.controller

import com.xyz.entity.Article
import com.xyz.entity.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import com.xyz.repository.ArticleRepository
import com.xyz.service.ArticleService
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import java.util.*
import javax.servlet.http.HttpSession


@Controller
class BlogController{

    @Autowired lateinit var articleService : ArticleService
/*init Article data
    @Bean
    fun init(repository: ArticleRepository) = CommandLineRunner {
        val article = Article()
        article.author = "Kotlin"
        article.title = "极简Kotlin教程 ${Date()}"
        article.content = "Easy Kotlin ${Date()}"
        repository.save(article)
    }*/


    @GetMapping("listAllArticleView")
    fun listAllArticleView(model: Model): ModelAndView {
        model.addAttribute("articles", articleService.findAll())
        return ModelAndView("blog/list")
    }

    @GetMapping("listMyArticleView")
    fun myArticle(session : HttpSession,model : Model): ModelAndView {
        var userDetails : Users = SecurityContextHolder.getContext()
                .authentication.principal as Users
        var author : String = userDetails.username
        var cname : String = userDetails.userDetail.cname
        model.addAttribute("articles",articleService.findAllByAuthor(author))
        model.addAttribute("author",cname)
        return ModelAndView("blog/listMy")
    }

    @PostMapping("saveArticle")
    @ResponseBody
    fun saveArticle(article: Article): Article? {
        var userDetails : Users = SecurityContextHolder.getContext()
                .authentication.principal as Users
        var author : String = userDetails.username
        article.author = author
        article.gmtCreated = Date()
        article.gmtModified = Date()
        article.version = 0
        return articleService.save(article)
    }

    @PostMapping("updateArticle")
    @ResponseBody
    fun updateArticle(article: Article): Article? {
        var userDetails : Users = SecurityContextHolder.getContext()
                .authentication.principal as Users
        var author : String = userDetails.username
        article.author = author
        article.gmtModified = Date()
        return articleService.save(article)
    }

    @GetMapping("detailArticleView")
    fun detailArticleView(id: Long, model: Model): ModelAndView {
        model.addAttribute("article", articleService.findById(id))
        return ModelAndView("blog/detailArticleView")
    }

    @GetMapping("editArticle")
    fun editArticle(id:Long,model:Model):ModelAndView {
        model.addAttribute("article",articleService.findById(id))
        return ModelAndView("blog/editArticle")
    }

}
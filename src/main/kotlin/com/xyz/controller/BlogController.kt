package com.xyz.controller

import com.xyz.entity.Article
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import com.xyz.repository.ArticleRepository
import com.xyz.service.ArticleService
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import java.util.*


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

    @PostMapping("saveArticle")
    @ResponseBody
    fun saveArticle(article: Article): Article? {
        article.gmtCreated = Date()
        article.gmtModified = Date()
        article.version = 0
        return articleService.save(article)
    }

    @GetMapping("detailArticleView")
    fun detailArticleView(id: Long, model: Model): ModelAndView {
        model.addAttribute("article", articleService.findById(id))
        return ModelAndView("blog/detailArticleView")
    }


}
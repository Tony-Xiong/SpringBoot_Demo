package com.xyz.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import com.xyz.repository.ArticleRepository


@Controller
class BlogController{

    @Autowired lateinit var articleRepository : ArticleRepository
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
        model.addAttribute("articles", articleRepository?.findAll())
        return ModelAndView("blog/list")
    }

}
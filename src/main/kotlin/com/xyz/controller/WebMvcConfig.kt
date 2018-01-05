package com.xyz.controller

import freemarker.ext.jsp.TaglibFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer
import javax.annotation.PostConstruct

@Configuration
class WebMvcConfig : WebMvcConfigurer {
    // 注册简单请求转发跳转View的RequestMapping Controller
    @Autowired
    private var configurer : FreeMarkerConfigurer = FreeMarkerConfigurer()

    @PostConstruct
    fun freeMarkerConfigurer(){
        var tlds : MutableList<String> = mutableListOf()
        tlds.add("/META-INF/security.tld")
        val taglibFactory : TaglibFactory = configurer.taglibFactory
        taglibFactory.classpathTlds = tlds

        if (taglibFactory.objectWrapper==null){
            taglibFactory.objectWrapper = configurer.configuration.objectWrapper
        }
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        //写文章的RequestMapping
        registry.addViewController("addArticleView").setViewName("blog/addArticleView")
        registry.addViewController("login").setViewName("login")
    }
}
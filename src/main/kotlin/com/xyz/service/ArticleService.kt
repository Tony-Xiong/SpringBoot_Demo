package com.xyz.service

import com.xyz.entity.Article
import com.xyz.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService {
    @Autowired lateinit var articleRepository : ArticleRepository

    fun findAll(): List<Article> = articleRepository.findAll()

    fun save(article : Article): Article = articleRepository.save(article)

    fun findById(id: Long): Article =  articleRepository.findById(id).get()

    fun delete(article : Article) = articleRepository.delete(article)
}

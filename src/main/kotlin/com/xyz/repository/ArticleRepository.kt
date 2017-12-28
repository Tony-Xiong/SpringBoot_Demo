package com.xyz.repository

import com.xyz.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository <Article,Long>
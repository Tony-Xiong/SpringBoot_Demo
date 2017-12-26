package com.xyz

import com.xyz.controller.IndexController
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication



@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(IndexController::class.java,*args)
}

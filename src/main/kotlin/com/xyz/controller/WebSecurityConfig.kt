package com.xyz.controller

import com.xyz.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
        class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Bean fun userService() : UserDetailsService = UserService()

    override fun configure(auth : AuthenticationManagerBuilder) {
        auth.userDetailsService(userService())
    }
//
//    override fun configure(http: HttpSecurity?) {
//        http!!.authorizeRequests()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
//                .and()
//                .logout()
//                .permitAll()
//    }
//
    override fun configure(web: WebSecurity?) {
        web?.ignoring()?.antMatchers("/css/**")
    }

    
}
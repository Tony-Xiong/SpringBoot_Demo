package com.xyz.controller

import com.xyz.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
        class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Bean fun userService() : UserDetailsService = UserService()

    override fun configure(auth : AuthenticationManagerBuilder) {
        auth.userDetailsService(userService())
    }

    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
                    .and()
                .httpBasic()
    }

    override fun configure(web: WebSecurity) {
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/register/**")
                .antMatchers("/error")
    }

    
}
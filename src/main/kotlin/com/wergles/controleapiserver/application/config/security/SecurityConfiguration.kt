package com.wergles.controleapiserver.application.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailsService: UserDetailsService,
    private val jwtUtils: JWTUtils
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.csrf()?.disable()
            ?.authorizeRequests()
//            ?.antMatchers(HttpMethod.POST, "/logian")?.permitAll()
            ?.antMatchers(HttpMethod.POST, "/account/create")?.permitAll()
            ?.anyRequest()?.authenticated()?.and()
        http?.addFilterBefore(
            JWTAuthenticationFilter(authManager = authenticationManager(), jwtUtils = jwtUtils),
            UsernamePasswordAuthenticationFilter().javaClass
        )
        http?.addFilterBefore(
            JWTAuthorizationFilter(jwtUtils),
            UsernamePasswordAuthenticationFilter().javaClass
        )
        http?.sessionManagement()
            ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }

    @Bean
    fun bCryptPasswordEncoded(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userDetailsService)?.passwordEncoder(bCryptPasswordEncoded())
    }
}

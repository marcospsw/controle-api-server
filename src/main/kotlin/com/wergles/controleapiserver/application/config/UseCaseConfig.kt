package com.wergles.controleapiserver.application.config

import com.wergles.controleapiserver.application.usecase.user.CreateUserUseCase
import com.wergles.controleapiserver.application.usecase.user.GetUserByIdUseCase
import com.wergles.controleapiserver.infra.gateway.UserGateway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {
    @Bean
    fun createUserUseCase(userGateway: UserGateway) = CreateUserUseCase(userGateway = userGateway)

    @Bean
    fun getUserByIdUseCase(userGateway: UserGateway) = GetUserByIdUseCase(userGateway = userGateway)
}

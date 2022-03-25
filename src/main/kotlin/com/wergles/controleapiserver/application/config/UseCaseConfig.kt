package com.wergles.controleapiserver.application.config

import com.wergles.controleapiserver.application.usecase.user.CreateUserUseCase
import com.wergles.controleapiserver.application.usecase.user.DeleteUserUseCase
import com.wergles.controleapiserver.application.usecase.user.GetUserByIdUseCase
import com.wergles.controleapiserver.application.usecase.user.UpdateUserUseCase
import com.wergles.controleapiserver.infra.gateway.UserGateway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {
    @Bean
    fun createUserUseCase(userGateway: UserGateway) = CreateUserUseCase(userGateway = userGateway)

    @Bean
    fun getUserByIdUseCase(userGateway: UserGateway) = GetUserByIdUseCase(userGateway = userGateway)

    @Bean
    fun updateUserUseCase(userGateway: UserGateway) = UpdateUserUseCase(userGateway = userGateway)

    @Bean
    fun deleteUserUseCase(userGateway: UserGateway) = DeleteUserUseCase(userGateway = userGateway)
}

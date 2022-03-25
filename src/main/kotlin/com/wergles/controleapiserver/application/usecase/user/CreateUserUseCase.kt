package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User
import com.wergles.controleapiserver.infra.gateway.UserGateway

class CreateUserUseCase(
    private val userGateway: UserGateway
) {
    private val logger = Logger(this.javaClass)

    suspend fun execute(user: User): User {
        logger.info("Create User UseCase -> Starting create user")
        return userGateway.createUser(user).also {
            logger.info("Create User UseCase -> Finish create user")
        }
    }
}

package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User
import com.wergles.controleapiserver.infra.gateway.UserGateway

class UpdateUserUseCase(private val userGateway: UserGateway) {
    private val logger = Logger(this.javaClass)

    suspend fun execute(id: String, newUser: User): User {
        logger.info("Edi User UseCase -> Starting update user")
        return userGateway.updateUser(id, newUser).also {
            logger.info("Get User UseCase -> Finish update user")
        }
    }
}
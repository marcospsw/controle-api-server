package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.gateway.UserGateway

class DeleteUserUseCase(private val userGateway: UserGateway) {
    private val logger = Logger(this.javaClass)

    suspend fun execute(id: String) {
        logger.info("Delete User UseCase -> Starting delete user")
        return userGateway.deleteUser(id).also {
            logger.info("Delete User UseCase -> Finish delete user")
        }
    }
}
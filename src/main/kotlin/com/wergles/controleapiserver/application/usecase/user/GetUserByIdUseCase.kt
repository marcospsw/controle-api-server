package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User
import com.wergles.controleapiserver.infra.gateway.UserGateway

class GetUserByIdUseCase(
    private val userGateway: UserGateway
) {
    private val logger = Logger(this.javaClass)

    suspend fun execute(id: String): User {
        logger.info("Get User UseCase -> Starting get user")
        return userGateway.getUserById(id).also {
            logger.info("Get User UseCase -> Finish get user")
        }
    }
}

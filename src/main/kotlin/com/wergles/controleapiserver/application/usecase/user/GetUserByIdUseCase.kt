package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User

class GetUserByIdUseCase(private val userGateway: IUserGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(): User {
        logger.info("Get User UseCase -> Starting get user")
        val userId = userGateway.getAuthenticatedUserId()
        return userGateway.getUserById(userId).also {
            logger.info("Get User UseCase -> Successfully get user")
        }
    }
}

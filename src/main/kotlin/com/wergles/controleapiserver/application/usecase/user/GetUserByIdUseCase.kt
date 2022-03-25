package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User

class GetUserByIdUseCase(private val userGateway: IUserGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String): User {
        logger.info("Get User UseCase -> Starting get user")
        return userGateway.getUserById(id).also {
            logger.info("Get User UseCase -> Successfully get user")
        }
    }
}

package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger

class DeleteUserUseCase(private val userGateway: IUserGateway) {
    private val logger = Logger(this.javaClass)

    fun execute() {
        logger.info("Delete User UseCase -> Starting delete user")
        val userId = userGateway.getAuthenticatedUserId()
        return userGateway.deleteUser(userId).also {
            logger.info("Delete User UseCase -> Successfully delete user")
        }
    }
}

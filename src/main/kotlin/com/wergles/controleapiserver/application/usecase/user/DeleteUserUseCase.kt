package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger

class DeleteUserUseCase(private val userGateway: IUserGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String) {
        logger.info("Delete User UseCase -> Starting delete user")
        return userGateway.deleteUser(id).also {
            logger.info("Delete User UseCase -> Successfully delete user")
        }
    }
}

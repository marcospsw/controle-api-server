package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User

class UpdateUserUseCase(private val userGateway: IUserGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(newUser: User): User {
        logger.info("Edi User UseCase -> Starting update user")
        val user = userGateway.getAuthenticatedUser()
        return userGateway.updateUser(user.id, newUser).also {
            logger.info("Get User UseCase -> Successfully update user")
        }
    }
}

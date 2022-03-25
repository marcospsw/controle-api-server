package com.wergles.controleapiserver.application.usecase.user

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User

class CreateUserUseCase(private val userGateway: IUserGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(user: User): User {
        logger.info("Create User UseCase -> Starting create user")
        return userGateway.createUser(user).also {
            logger.info("Create User UseCase -> Successfully create user")
        }
    }
}

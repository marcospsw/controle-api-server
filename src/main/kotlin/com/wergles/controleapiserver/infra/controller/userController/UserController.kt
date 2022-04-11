package com.wergles.controleapiserver.infra.controller.userController

import com.wergles.controleapiserver.application.usecase.user.CreateUserUseCase
import com.wergles.controleapiserver.application.usecase.user.DeleteUserUseCase
import com.wergles.controleapiserver.application.usecase.user.GetUserByIdUseCase
import com.wergles.controleapiserver.application.usecase.user.UpdateUserUseCase
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.userController.dto.CreateUserRequestDTO
import com.wergles.controleapiserver.infra.controller.userController.dto.UpdateUserRequestDTO
import com.wergles.controleapiserver.infra.controller.userController.dto.UserResponseDTO
import com.wergles.controleapiserver.infra.controller.userController.dto.toResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) {
    private val logger = Logger(this.javaClass)

    @GetMapping
    fun getUser(): UserResponseDTO {
        logger.info("User Controller -> Starting get user")
        return getUserByIdUseCase.execute().toResponse().also {
            logger.info("User Controller -> Successfully get user")
        }
    }

    @PostMapping
    fun createUser(@RequestBody userRequest: CreateUserRequestDTO): UserResponseDTO {
        logger.info("User Controller -> Starting create user")
        return createUserUseCase.execute(userRequest.toDomain()).toResponse().also {
            logger.info("User Controller -> Successfully create user")
        }
    }

    @PutMapping
    fun updateUser(@RequestBody userRequest: UpdateUserRequestDTO): UserResponseDTO {
        logger.info("User Controller -> Starting update user")
        return updateUserUseCase.execute(userRequest.toDomain()).toResponse().also {
            logger.info("User Controller -> Successfully update user")
        }
    }

    @DeleteMapping
    fun deleteUser() {
        logger.info("User Controller -> Starting delete user")
        return deleteUserUseCase.execute().also {
            logger.info("User Controller -> Successfully delete user")
        }
    }
}

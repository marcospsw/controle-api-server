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
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) {
    private val logger = Logger(this.javaClass)

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: String): UserResponseDTO {
        logger.info("User Controller -> Starting get user")
        return getUserByIdUseCase.execute(id).toResponse().also {
            logger.info("User Controller -> Successfully get user")
        }
    }

    @PostMapping("/create")
    fun createUser(@RequestBody userRequest: CreateUserRequestDTO): UserResponseDTO {
        logger.info("User Controller -> Starting create user")
        return createUserUseCase.execute(userRequest.toDomain()).toResponse().also {
            logger.info("User Controller -> Successfully create user")
        }
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable("id") id: String, @RequestBody userRequest: UpdateUserRequestDTO): UserResponseDTO {
        logger.info("User Controller -> Starting update user")
        return updateUserUseCase.execute(id, userRequest.toDomain()).toResponse().also {
            logger.info("User Controller -> Successfully update user")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable("id") id: String) {
        logger.info("User Controller -> Starting delete user")
        return deleteUserUseCase.execute(id).also {
            logger.info("User Controller -> Successfully delete user")
        }
    }
}

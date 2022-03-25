package com.wergles.controleapiserver.infra.controller

import com.wergles.controleapiserver.application.usecase.user.CreateUserUseCase
import com.wergles.controleapiserver.application.usecase.user.DeleteUserUseCase
import com.wergles.controleapiserver.application.usecase.user.GetUserByIdUseCase
import com.wergles.controleapiserver.application.usecase.user.UpdateUserUseCase
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.dto.CreateUserRequest
import com.wergles.controleapiserver.infra.controller.dto.UpdateUserRequest
import com.wergles.controleapiserver.infra.controller.dto.UserResponse
import com.wergles.controleapiserver.infra.controller.dto.toResponse
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
    suspend fun getUser(@PathVariable("id") id: String): UserResponse {
        logger.info("User Controller -> Starting finding user")
        return getUserByIdUseCase.execute(id).toResponse().also {
            logger.info("User Controller -> Finish finding user")
        }
    }

    @PostMapping("/create")
    suspend fun createUser(@RequestBody userRequest: CreateUserRequest): UserResponse {
        logger.info("User Controller -> Starting create user")
        return createUserUseCase.execute(userRequest.toDomain()).toResponse().also {
            logger.info("User Controller -> Finish create user")
        }
    }

    @PutMapping("/{id}")
    suspend fun updateUser(@PathVariable("id") id: String, @RequestBody userRequest: UpdateUserRequest): UserResponse {
        logger.info("User Controller -> Starting update user")
        return updateUserUseCase.execute(id, userRequest.toDomain()).toResponse().also {
            logger.info("User Controller -> Finish update user")
        }
    }

    @DeleteMapping("/{id}")
    suspend fun deleteUser(@PathVariable("id") id: String) {
        logger.info("User Controller -> Starting finding user")
        return deleteUserUseCase.execute(id).also {
            logger.info("User Controller -> Finish finding user")
        }
    }
}

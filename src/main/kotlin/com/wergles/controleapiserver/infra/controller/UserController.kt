package com.wergles.controleapiserver.infra.controller

import com.wergles.controleapiserver.application.usecase.user.CreateUserUseCase
import com.wergles.controleapiserver.application.usecase.user.GetUserByIdUseCase
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.dto.CreateUserRequest
import com.wergles.controleapiserver.infra.controller.dto.UserResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class UserController(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) {
    private val logger = Logger(this.javaClass)

    @PostMapping("/create")
    suspend fun createUser(@RequestBody user: CreateUserRequest): UserResponse {
        logger.info("User Controller -> Starting create user")
        return createUserUseCase.execute(user.toDomain()).let {
            UserResponse(
                email = it.email,
                name = it.name,
                cpf = it.cpf
            ).toSuccess(it)
        }.also {
            logger.info("User Controller -> Finish create user")
        }
    }

    @GetMapping("/{id}")
    suspend fun getUser(@PathVariable("id") id: String): UserResponse {
        logger.info("User Controller -> Starting create user")
        return getUserByIdUseCase.execute(id).let {
            UserResponse(
                email = it.email,
                name = it.name,
                cpf = it.cpf
            ).toSuccess(it)
        }
    }
}

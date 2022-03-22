package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User
import com.wergles.controleapiserver.domain.exception.BadGatewayException
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.model.UserDocument
import com.wergles.controleapiserver.infra.gateway.repository.UserRepository
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserGateway(private val userRepository: UserRepository) : IUserGateway {
    val logger = Logger(this.javaClass)

    override suspend fun getUserById(id: String): User {
        logger.info("User Gateway -> Starting get users")
        return userRepository.findById(id).awaitSingleOrNull()?.toDomain()
            .also { logger.info("User Gateway -> Successfully get users") }
            ?: throw NotFoundException("User as not found")
    }

    override suspend fun createUser(user: User): User {
        logger.info("User Gateway -> Starting create user")
        return userRepository.save(UserDocument(user)).awaitSingleOrNull()?.toDomain().also {
            logger.info("User Gateway -> Successfully create user")
        } ?: throw BadGatewayException("User Gateway -> Error on save user")
    }

    override suspend fun editUser(id: String, newUser: User): User {
        logger.info("User Gateway -> Starting edit user")
        val user = userRepository.findById(id).awaitSingleOrNull()
            .also { logger.info("User Gateway -> Successfully get user") }
            ?: throw NotFoundException("User as not found")
        return userRepository.save(
            user.copy(
                name = newUser.name,
                email = newUser.email,
                password = newUser.password,
                avatar_url = newUser.avatar_url,
                updated_at = LocalDateTime.now()
            )
        ).awaitSingleOrNull()?.toDomain()
            .also { logger.info("User Gateway -> Successfully edit user") }
            ?: throw BadGatewayException("User Gateway -> Error on edit user")
    }

    override suspend fun deleteUser(id: String) {
        logger.info("User Gateway -> Starting edit user")
        userRepository.deleteById(id).awaitSingleOrNull()
            .also { logger.info("User Gateway -> Successfully delete user") }
            ?: throw NotFoundException("User as not found")
    }
}

package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.model.UserDocument
import com.wergles.controleapiserver.infra.gateway.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserGateway(private val userRepository: UserRepository) : IUserGateway {
    val logger = Logger(this.javaClass)

    override fun getUserById(id: String): User {
        logger.info("User Gateway -> Starting get users")
        return userRepository.findByIdOrNull(id)?.toDomain()
            .also { logger.info("User Gateway -> Successfully get users") }
            ?: throw NotFoundException("User as not found")
    }

    override fun createUser(user: User): User {
        logger.info("User Gateway -> Starting create user")
        return userRepository.save(UserDocument(user)).toDomain().also {
            logger.info("User Gateway -> Successfully create user")
        }
    }

    override fun updateUser(id: String, newUser: User): User {
        logger.info("User Gateway -> Starting edit user")
        val user = userRepository.findByIdOrNull(id)
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
        ).toDomain()
            .also { logger.info("User Gateway -> Successfully edit user") }
    }

    override fun deleteUser(id: String) {
        logger.info("User Gateway -> Starting delete user")
        userRepository.deleteById(id)
            .also { logger.info("User Gateway -> Successfully delete user") }
    }
}

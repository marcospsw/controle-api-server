package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IUserGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.User
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.repository.UserRepository
import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.springframework.stereotype.Service

@Service
class UserGateway(private val userRepository: UserRepository) : IUserGateway {
    val logger = Logger(this.javaClass)

    override suspend fun getUser(id: String): User {
        logger.info("User Gateway -> Starting get users")
        return userRepository.findById(id).awaitSingleOrNull()?.toDomain()
            .also { logger.info("User Gateway -> Successfully get users") }
            ?: throw NotFoundException("User as not found")
    }

    override suspend fun createUser(user: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun editUser(user: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }
}
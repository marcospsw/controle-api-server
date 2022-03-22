package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.User

interface IUserGateway {
    suspend fun getUser(id: String): User
    suspend fun createUser(user: User): User
    suspend fun editUser(user: User): User
    suspend fun deleteUser(user: User)
}

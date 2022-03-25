package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.User

interface IUserGateway {
    suspend fun getUserById(id: String): User
    suspend fun createUser(user: User): User
    suspend fun updateUser(id: String, newUser: User): User
    suspend fun deleteUser(id: String)
}

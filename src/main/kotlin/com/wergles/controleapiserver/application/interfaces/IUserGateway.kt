package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.User
import com.wergles.controleapiserver.domain.entity.UserAuthenticated

interface IUserGateway {
    fun getUserById(id: String): User
    fun createUser(user: User): User
    fun updateUser(id: String, newUser: User): User
    fun deleteUser(id: String)
    fun getAuthenticatedUser(): UserAuthenticated
}

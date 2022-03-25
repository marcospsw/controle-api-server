package com.wergles.controleapiserver.infra.controller.dto

import com.wergles.controleapiserver.domain.entity.User
import java.time.LocalDateTime

data class UserResponse(
    val id: String? = null,
    val name: String,
    val email: String,
    val cpf: String,
    val avatar_url: String? = null,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null
) {
    fun toSuccess(user: User) = UserResponse(
        id = user.id,
        name = user.name,
        email = user.email,
        cpf = user.cpf,
        avatar_url = user.avatar_url,
        created_at = user.created_at,
        updated_at = user.updated_at
    )
}

package com.wergles.controleapiserver.infra.controller.userController.dto

import com.wergles.controleapiserver.domain.entity.User
import java.time.LocalDateTime

data class UpdateUserRequestDTO(
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val avatar_url: String? = null,
) {
    fun toDomain() = User(
        name = name,
        email = email,
        cpf = cpf,
        password = password,
        avatar_url = avatar_url,
        created_at = LocalDateTime.now()
    )
}

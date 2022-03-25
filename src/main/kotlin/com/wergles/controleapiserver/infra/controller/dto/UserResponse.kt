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
)

fun User.toResponse() = UserResponse(
    id = id,
    name = name,
    email = email,
    cpf = cpf,
    avatar_url = avatar_url,
    created_at = created_at,
    updated_at = updated_at
)


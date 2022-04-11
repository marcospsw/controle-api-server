package com.wergles.controleapiserver.domain.entity

import java.time.LocalDateTime

data class UserAuthenticated(
    val id: String,
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val avatar_url: String? = null,
    val created_at: LocalDateTime,
)

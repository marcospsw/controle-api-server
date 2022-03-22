package com.wergles.controleapiserver.domain.entity

import java.time.LocalDateTime

data class User(
    val id: String? = null,
    val name: String,
    val cpf: String,
    val password: String,
    val avatar_url: String? = null,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null
)

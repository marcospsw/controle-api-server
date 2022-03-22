package com.wergles.controleapiserver.domain.entity

import java.math.BigDecimal
import java.time.LocalDateTime

data class ExtraExpense(
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val user_id: String,
    val value: BigDecimal,
    val month: Int,
    val year: Int,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
)

package com.wergles.controleapiserver.domain.entity

import java.math.BigDecimal
import java.time.LocalDateTime

data class Expense(
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val userId: String,
    val value: BigDecimal,
    val month: Int? = null,
    val year: Int? = null,
    val fixed: Boolean,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
)

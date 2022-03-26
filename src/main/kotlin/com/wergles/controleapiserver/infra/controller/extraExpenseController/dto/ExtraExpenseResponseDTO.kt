package com.wergles.controleapiserver.infra.controller.extraExpenseController.dto

import com.wergles.controleapiserver.domain.entity.ExtraExpense
import java.math.BigDecimal
import java.time.LocalDateTime

class ExtraExpenseResponseDTO(
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val month: Int,
    val year: Int,
    val userId: String,
    val value: BigDecimal,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
)

fun ExtraExpense.toResponse() = ExtraExpenseResponseDTO(
    id = id,
    title = title,
    description = description,
    month = month,
    year = year,
    userId = userId,
    value = value,
    created_at = created_at,
    updated_at = updated_at
)
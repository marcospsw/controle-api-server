package com.wergles.controleapiserver.infra.controller.expenseController.dto

import com.wergles.controleapiserver.domain.entity.Expense
import java.math.BigDecimal
import java.time.LocalDateTime

class ExpenseResponseDTO(
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val month: Int,
    val year: Int,
    val userId: String,
    val value: BigDecimal,
    val fixed: Boolean,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
)

fun Expense.toResponse() = ExpenseResponseDTO(
    id = id,
    title = title,
    description = description,
    month = month,
    year = year,
    userId = userId,
    value = value,
    fixed = fixed,
    created_at = created_at,
    updated_at = updated_at
)

package com.wergles.controleapiserver.infra.controller.extraExpenseController.dto

import com.wergles.controleapiserver.domain.entity.ExtraExpense
import java.math.BigDecimal
import java.time.LocalDateTime

class CreateExtraExpenseRequestDTO(
    val title: String,
    val description: String? = null,
    val month: Int,
    val year: Int,
    val userId: String,
    val value: BigDecimal,
) {
    fun toDomain() = ExtraExpense(
        title = title,
        description = description,
        month = month,
        year = year,
        userId = userId,
        value = value,
        created_at = LocalDateTime.now()
    )
}
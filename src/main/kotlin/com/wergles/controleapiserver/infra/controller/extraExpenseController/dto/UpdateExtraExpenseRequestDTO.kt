package com.wergles.controleapiserver.infra.controller.extraExpenseController.dto

import com.wergles.controleapiserver.domain.entity.ExtraExpense
import java.math.BigDecimal
import java.time.LocalDateTime

class UpdateExtraExpenseRequestDTO(
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
        updated_at = LocalDateTime.now()
    )
}
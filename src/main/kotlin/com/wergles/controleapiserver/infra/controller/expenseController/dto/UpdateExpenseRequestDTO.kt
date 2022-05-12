package com.wergles.controleapiserver.infra.controller.expenseController.dto

import com.wergles.controleapiserver.domain.entity.Expense
import java.math.BigDecimal
import java.time.LocalDateTime

class UpdateExpenseRequestDTO(
    val title: String,
    val description: String? = null,
    val month: Int,
    val year: Int,
    val userId: String,
    val value: BigDecimal,
    val isFixed: Boolean,
) {
    fun toDomain() = Expense(
        title = title,
        description = description,
        month = month,
        year = year,
        userId = userId,
        value = value,
        isFixed = isFixed,
        updated_at = LocalDateTime.now()
    )
}

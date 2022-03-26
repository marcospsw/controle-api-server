package com.wergles.controleapiserver.infra.controller.fixedExpenseController.dto

import com.wergles.controleapiserver.domain.entity.FixedExpense
import java.math.BigDecimal
import java.time.LocalDateTime

class UpdateFixedExpenseRequestDTO(
    val title: String,
    val description: String? = null,
    val userId: String,
    val value: BigDecimal,
) {
    fun toDomain() = FixedExpense(
        title = title,
        description = description,
        userId = userId,
        value = value,
        updated_at = LocalDateTime.now()
    )
}
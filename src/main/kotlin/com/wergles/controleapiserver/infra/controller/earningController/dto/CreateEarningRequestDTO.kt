package com.wergles.controleapiserver.infra.controller.earningController.dto

import com.wergles.controleapiserver.domain.entity.Earning
import java.math.BigDecimal
import java.time.LocalDateTime

class CreateEarningRequestDTO(
    val title: String,
    val description: String? = null,
    val month: Int,
    val year: Int,
    val userId: String,
    val value: BigDecimal,
    val isFixed: Boolean
) {
    fun toDomain() = Earning(
        title = title,
        description = description,
        month = month,
        year = year,
        userId = userId,
        value = value,
        isFixed = isFixed,
        created_at = LocalDateTime.now()
    )
}

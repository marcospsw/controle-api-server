package com.wergles.controleapiserver.infra.controller.extraEarningController.dto

import com.wergles.controleapiserver.domain.entity.ExtraEarning
import java.math.BigDecimal
import java.time.LocalDateTime

class CreateExtraEarningRequestDTO(
    val title: String,
    val description: String? = null,
    val month: Int,
    val year: Int,
    val userId: String,
    val value: BigDecimal,
) {
    fun toDomain() = ExtraEarning(
        title = title,
        description = description,
        month = month,
        year = year,
        userId = userId,
        value = value,
        created_at = LocalDateTime.now()
    )
}
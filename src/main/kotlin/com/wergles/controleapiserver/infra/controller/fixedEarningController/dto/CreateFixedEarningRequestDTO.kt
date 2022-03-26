package com.wergles.controleapiserver.infra.controller.fixedEarningController.dto

import com.wergles.controleapiserver.domain.entity.FixedEarning
import java.math.BigDecimal
import java.time.LocalDateTime

class CreateFixedEarningRequestDTO(
    val title: String,
    val description: String? = null,
    val userId: String,
    val value: BigDecimal,
) {
    fun toDomain() = FixedEarning(
        title = title,
        description = description,
        userId = userId,
        value = value,
        created_at = LocalDateTime.now()
    )
}
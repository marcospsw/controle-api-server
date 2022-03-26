package com.wergles.controleapiserver.infra.controller.fixedEarningController.dto

import com.wergles.controleapiserver.domain.entity.FixedEarning
import java.math.BigDecimal
import java.time.LocalDateTime

class UpdateFixedEarningRequestDTO(
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
        updated_at = LocalDateTime.now()
    )
}
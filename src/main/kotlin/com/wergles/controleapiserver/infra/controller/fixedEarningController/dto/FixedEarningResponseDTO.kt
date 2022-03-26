package com.wergles.controleapiserver.infra.controller.fixedEarningController.dto

import com.wergles.controleapiserver.domain.entity.FixedEarning
import java.math.BigDecimal
import java.time.LocalDateTime

class FixedEarningResponseDTO(
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val userId: String,
    val value: BigDecimal,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
)

fun FixedEarning.toResponse() = FixedEarningResponseDTO(
    id = id,
    title = title,
    description = description,
    userId = userId,
    value = value,
    created_at = created_at,
    updated_at = updated_at
)
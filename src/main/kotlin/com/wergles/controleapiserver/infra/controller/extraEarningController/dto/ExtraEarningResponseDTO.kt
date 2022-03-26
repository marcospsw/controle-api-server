package com.wergles.controleapiserver.infra.controller.extraEarningController.dto

import com.wergles.controleapiserver.domain.entity.ExtraEarning
import java.math.BigDecimal
import java.time.LocalDateTime

class ExtraEarningResponseDTO(
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val month: Int,
    val year: Int,
    val userId: String,
    val value: BigDecimal,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
)

fun ExtraEarning.toResponse() = ExtraEarningResponseDTO(
    id = id,
    title = title,
    description = description,
    month = month,
    year = year,
    userId = userId,
    value = value,
    created_at = created_at,
    updated_at = updated_at
)
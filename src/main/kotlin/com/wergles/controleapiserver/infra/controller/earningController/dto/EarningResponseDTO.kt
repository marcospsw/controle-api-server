package com.wergles.controleapiserver.infra.controller.earningController.dto

import com.wergles.controleapiserver.domain.entity.Earning
import java.math.BigDecimal
import java.time.LocalDateTime

class EarningResponseDTO(
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val month: Int,
    val year: Int,
    val userId: String,
    val value: BigDecimal,
    val isFixed: Boolean,
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
)

fun Earning.toResponse() = EarningResponseDTO(
    id = id,
    title = title,
    description = description,
    month = month,
    year = year,
    userId = userId,
    value = value,
    isFixed = isFixed,
    created_at = created_at,
    updated_at = updated_at
)

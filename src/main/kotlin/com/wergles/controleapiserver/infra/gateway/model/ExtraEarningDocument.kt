package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.ExtraEarning
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "extra_earnings")
data class ExtraEarningDocument(
    @Id
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val userId: String,
    val value: BigDecimal,
    val month: Int,
    val year: Int,
    @CreatedDate
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
) {
    constructor(extraEarning: ExtraEarning) : this(
        id = extraEarning.id,
        title = extraEarning.title,
        description = extraEarning.description,
        month = extraEarning.month,
        year = extraEarning.year,
        userId = extraEarning.userId,
        value = extraEarning.value,
        created_at = extraEarning.created_at,
        updated_at = extraEarning.updated_at
    )

    fun toDomain() = ExtraEarning(
        id = id,
        title = title,
        description = description,
        userId = userId,
        value = value,
        month = month,
        year = year,
        created_at = created_at,
        updated_at = updated_at
    )
}

package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.FixedEarning
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "fixed_earnings")
data class FixedEarningDocument(
    @Id
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val userId: String,
    val value: BigDecimal,
    @CreatedDate
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
) {
    constructor(fixedEarning: FixedEarning) : this(
        id = fixedEarning.id,
        title = fixedEarning.title,
        description = fixedEarning.description,
        userId = fixedEarning.userId,
        value = fixedEarning.value,
        created_at = fixedEarning.created_at,
        updated_at = fixedEarning.updated_at
    )

    fun toDomain() = FixedEarning(
        id = id,
        title = title,
        description = description,
        userId = userId,
        value = value,
        created_at = created_at,
        updated_at = updated_at
    )
}

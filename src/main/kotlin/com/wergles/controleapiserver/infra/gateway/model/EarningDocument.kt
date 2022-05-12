package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.Earning
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import java.math.BigDecimal
import java.time.LocalDateTime

data class EarningDocument(
    @Id
    override val id: String? = null,
    override val title: String,
    override val description: String?,
    override val userId: String,
    override val value: BigDecimal,
    override val month: Int?,
    override val year: Int?,
    override val fixed: Boolean,

    @CreatedDate
    override val created_at: LocalDateTime?,
    override val updated_at: LocalDateTime?
) : PostingDocument<Earning> {

    constructor(earning: Earning) : this(
        id = earning.id,
        title = earning.title,
        description = earning.description,
        month = earning.month,
        year = earning.year,
        userId = earning.userId,
        value = earning.value,
        fixed = earning.fixed,
        created_at = earning.created_at,
        updated_at = earning.updated_at
    )

    override fun toDomain() = Earning(
        id = id,
        title = title,
        description = description,
        userId = userId,
        value = value,
        month = month,
        year = year,
        fixed = fixed,
        created_at = created_at,
        updated_at = updated_at
    )
}

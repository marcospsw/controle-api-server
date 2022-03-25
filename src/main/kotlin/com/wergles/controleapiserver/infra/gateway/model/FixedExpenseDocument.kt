package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.FixedExpense
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "fixed_expenses")
data class FixedExpenseDocument(
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
    constructor(fixedExpense: FixedExpense) : this(
        id = fixedExpense.id,
        title = fixedExpense.title,
        description = fixedExpense.description,
        userId = fixedExpense.userId,
        value = fixedExpense.value,
        created_at = fixedExpense.created_at,
        updated_at = fixedExpense.updated_at
    )

    fun toDomain() = FixedExpense(
        id = id,
        title = title,
        description = description,
        userId = userId,
        value = value,
        created_at = created_at,
        updated_at = updated_at
    )
}

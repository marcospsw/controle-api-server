package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.ExtraExpense
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "extra_expenses")
data class ExtraExpenseDocument(
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
    constructor(extraExpense: ExtraExpense) : this(
        id = extraExpense.id,
        title = extraExpense.title,
        description = extraExpense.description,
        month = extraExpense.month,
        year = extraExpense.year,
        userId = extraExpense.userId,
        value = extraExpense.value,
        created_at = extraExpense.created_at,
        updated_at = extraExpense.updated_at
    )

    fun toDomain() = ExtraExpense(
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

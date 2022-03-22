package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.ExtraExpenses
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "extra_expenses")
data class ExtraExpensesDocument(
    @Id
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val user_id: String,
    val value: BigDecimal,
    val month: Int,
    val year: Int,
    @CreatedDate
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
) {
    fun toDomain() = ExtraExpenses(
        id = id,
        title = title,
        description = description,
        user_id = user_id,
        value = value,
        month = month,
        year = year,
        created_at = created_at,
        updated_at = updated_at
    )
}
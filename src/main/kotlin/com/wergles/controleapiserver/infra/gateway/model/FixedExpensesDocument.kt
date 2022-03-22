package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.FixedExpenses
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "fixed_expenses")
data class FixedExpensesDocument(
    @Id
    val id: String? = null,
    val title: String,
    val description: String? = null,
    val user_id: String,
    val value: BigDecimal,
    @CreatedDate
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null,
) {
    fun toDomain() = FixedExpenses(
        id = id,
        title = title,
        description = description,
        user_id = user_id,
        value = value,
        created_at = created_at,
        updated_at = updated_at
    )
}

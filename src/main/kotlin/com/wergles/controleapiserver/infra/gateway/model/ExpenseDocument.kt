package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.Expense
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import java.math.BigDecimal
import java.time.LocalDateTime

data class ExpenseDocument(
    @Id
    override val id: String? = null,
    override val title: String,
    override val description: String?,
    override val userId: String,
    override val value: BigDecimal,
    override val month: Int,
    override val year: Int,
    override val isFixed: Boolean,

    @CreatedDate
    override val created_at: LocalDateTime? = null,
    override val updated_at: LocalDateTime? = null

) : PostingDocument<Expense> {
    constructor(expense: Expense) : this(
        id = expense.id,
        title = expense.title,
        description = expense.description,
        month = expense.month,
        year = expense.year,
        userId = expense.userId,
        value = expense.value,
        isFixed = expense.isFixed,
        created_at = expense.created_at,
        updated_at = expense.updated_at
    )

    override fun toDomain() = Expense(
        id = id,
        title = title,
        description = description,
        userId = userId,
        value = value,
        month = month,
        year = year,
        isFixed = isFixed,
        created_at = created_at,
        updated_at = updated_at
    )
}

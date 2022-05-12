package com.wergles.controleapiserver.infra.gateway.model

import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime

@Document(collection = "postingDocument")
sealed interface PostingDocument<T> {
    val id: String?
    val title: String
    val description: String?
    val userId: String
    val value: BigDecimal
    val month: Int?
    val year: Int?
    val fixed: Boolean
    val created_at: LocalDateTime?
    val updated_at: LocalDateTime?

    fun toDomain(): T
}

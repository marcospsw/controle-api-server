package com.wergles.controleapiserver.infra.gateway.model

import com.wergles.controleapiserver.domain.entity.User
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "user")
data class UserDocument(
    @Id
    val id: String? = null,
    val name: String,
    @Indexed(unique = true)
    val cpf: String,
    val password: String,
    val avatar_url: String? = null,
    @CreatedDate
    val created_at: LocalDateTime? = null,
    val updated_at: LocalDateTime? = null
) {
    fun toDomain() = User(
        id = id,
        name = name,
        cpf = cpf,
        password = password,
        avatar_url = avatar_url,
        created_at = created_at,
        updated_at = updated_at
    )
}

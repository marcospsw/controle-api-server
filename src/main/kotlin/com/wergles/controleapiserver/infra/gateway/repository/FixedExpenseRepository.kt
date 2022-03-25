package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.FixedExpenseDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface FixedExpenseRepository : MongoRepository<FixedExpenseDocument, String> {
    fun getAllByUserId(userId: String): List<FixedExpenseDocument>?
}

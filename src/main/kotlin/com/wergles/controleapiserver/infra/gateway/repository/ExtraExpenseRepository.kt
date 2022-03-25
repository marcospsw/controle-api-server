package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.ExtraExpenseDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ExtraExpenseRepository : MongoRepository<ExtraExpenseDocument, String> {
    fun getAllByUserId(userId: String): List<ExtraExpenseDocument>?
    fun getAllByUserIdAndMonth(userId: String, month: Int): List<ExtraExpenseDocument>?
    fun getAllByUserIdAndYear(userId: String, year: Int): List<ExtraExpenseDocument>?
}

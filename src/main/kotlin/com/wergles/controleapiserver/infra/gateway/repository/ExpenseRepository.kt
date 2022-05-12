package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.ExpenseDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ExpenseRepository : MongoRepository<ExpenseDocument, String> {
    fun getAllByUserId(userId: String): List<ExpenseDocument>?
    fun getAllByUserIdAndMonth(userId: String, month: Int): List<ExpenseDocument>?
    fun getAllByUserIdAndYear(userId: String, year: Int): List<ExpenseDocument>?
    fun getAllByUserIdAndFixedIsTrue(userId: String): List<ExpenseDocument>?
}

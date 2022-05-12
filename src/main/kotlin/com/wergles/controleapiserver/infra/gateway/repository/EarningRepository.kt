package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.EarningDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface EarningRepository : MongoRepository<EarningDocument, String> {
    fun getAllByUserId(userId: String): List<EarningDocument>?
    fun getAllByUserIdAndMonth(userId: String, month: Int): List<EarningDocument>?
    fun getAllByUserIdAndYear(userId: String, year: Int): List<EarningDocument>?
}

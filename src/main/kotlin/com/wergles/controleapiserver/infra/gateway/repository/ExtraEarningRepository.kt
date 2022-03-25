package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.ExtraEarningDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ExtraEarningRepository : MongoRepository<ExtraEarningDocument, String> {
    fun getAllByUserId(userId: String): List<ExtraEarningDocument>?
    fun getAllByUserIdAndMonth(userId: String, month: Int): List<ExtraEarningDocument>?
    fun getAllByUserIdAndYear(userId: String, year: Int): List<ExtraEarningDocument>?
}

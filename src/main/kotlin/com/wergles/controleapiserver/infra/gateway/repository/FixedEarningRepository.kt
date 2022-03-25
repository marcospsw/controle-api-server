package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.FixedEarningDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface FixedEarningRepository : MongoRepository<FixedEarningDocument, String> {
    fun getAllByUserId(userId: String): List<FixedEarningDocument>?
}

package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.FixedEarningsDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface FixedEarningsRepository : ReactiveMongoRepository<FixedEarningsDocument, String> {
}
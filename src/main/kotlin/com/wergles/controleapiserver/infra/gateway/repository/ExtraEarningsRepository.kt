package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.ExtraEarningsDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ExtraEarningsRepository : ReactiveMongoRepository<ExtraEarningsDocument, String> {
}
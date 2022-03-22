package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.FixedExpensesDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface FixedExpensesRepository : ReactiveMongoRepository<FixedExpensesDocument, String> {
}
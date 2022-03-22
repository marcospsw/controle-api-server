package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.ExtraExpensesDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ExtraExpensesRepository : ReactiveMongoRepository<ExtraExpensesDocument, String> {
}
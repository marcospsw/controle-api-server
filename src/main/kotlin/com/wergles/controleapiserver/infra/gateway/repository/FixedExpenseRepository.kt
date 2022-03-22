package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.FixedExpenseDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface FixedExpenseRepository : ReactiveMongoRepository<FixedExpenseDocument, String>

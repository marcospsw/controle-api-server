package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.ExtraExpenseDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ExtraExpenseRepository : ReactiveMongoRepository<ExtraExpenseDocument, String>

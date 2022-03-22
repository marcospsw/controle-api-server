package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.FixedEarningDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface FixedEarningRepository : ReactiveMongoRepository<FixedEarningDocument, String>

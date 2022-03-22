package com.wergles.controleapiserver.infra.gateway.repository

import com.wergles.controleapiserver.infra.gateway.model.ExtraEarningDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ExtraEarningRepository : ReactiveMongoRepository<ExtraEarningDocument, String>

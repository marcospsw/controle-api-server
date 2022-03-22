package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.infra.gateway.repository.ExtraEarningsRepository
import org.springframework.stereotype.Service

@Service
class ExtraEarningsGateway(private val extraEarningsRepository: ExtraEarningsRepository)

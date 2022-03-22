package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.infra.gateway.repository.FixedEarningsRepository
import org.springframework.stereotype.Service

@Service
class FixedEarningsGateway(private val fixedEarningsRepository: FixedEarningsRepository)

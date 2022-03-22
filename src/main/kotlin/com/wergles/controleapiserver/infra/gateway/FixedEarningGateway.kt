package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.infra.gateway.repository.FixedEarningRepository
import org.springframework.stereotype.Service

@Service
class FixedEarningGateway(private val fixedEarningsRepository: FixedEarningRepository)

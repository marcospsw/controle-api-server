package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.infra.gateway.repository.ExtraEarningRepository
import org.springframework.stereotype.Service

@Service
class ExtraEarningGateway(private val extraEarningsRepository: ExtraEarningRepository)

package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.infra.gateway.repository.ExtraExpensesRepository
import org.springframework.stereotype.Service

@Service
class ExtraExpensesGateway(private val extraExpensesRepository: ExtraExpensesRepository)

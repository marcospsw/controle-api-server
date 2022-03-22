package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.infra.gateway.repository.ExtraExpenseRepository
import org.springframework.stereotype.Service

@Service
class ExtraExpenseGateway(private val extraExpensesRepository: ExtraExpenseRepository)

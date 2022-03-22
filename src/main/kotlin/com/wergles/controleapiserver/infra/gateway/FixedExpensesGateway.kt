package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.infra.gateway.repository.FixedExpensesRepository
import org.springframework.stereotype.Service

@Service
class FixedExpensesGateway(private val fixedExpensesRepository: FixedExpensesRepository) {
}
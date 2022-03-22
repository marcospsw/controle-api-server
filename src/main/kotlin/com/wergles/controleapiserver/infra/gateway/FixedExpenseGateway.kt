package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IFixedExpenseGateway
import com.wergles.controleapiserver.domain.entity.FixedExpense
import com.wergles.controleapiserver.infra.gateway.repository.FixedExpenseRepository
import com.wergles.controleapiserver.infra.gateway.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class FixedExpenseGateway(
    private val fixedExpensesRepository: FixedExpenseRepository,
    private val userRepository: UserRepository
) : IFixedExpenseGateway {
    override suspend fun getFixedExpenseById(userId: String, id: String): FixedExpense {
        TODO("Not yet implemented")
    }

    override suspend fun getFixedExpensesByMonth(userId: String, month: Int): List<FixedExpense> {
        TODO("Not yet implemented")
    }

    override suspend fun getFixedExpensesByYear(userId: String, year: Int): List<FixedExpense> {
        TODO("Not yet implemented")
    }
}

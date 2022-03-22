package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.FixedExpense

interface IFixedExpenseGateway {
    suspend fun getFixedExpenseById(userId: String, id: String): FixedExpense
    suspend fun getFixedExpensesByMonth(userId: String, month: Int): List<FixedExpense>
    suspend fun getFixedExpensesByYear(userId: String, year: Int): List<FixedExpense>
}

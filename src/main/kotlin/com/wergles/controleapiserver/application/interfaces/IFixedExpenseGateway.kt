package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.FixedExpense

interface IFixedExpenseGateway {
    fun getFixedExpenseById(id: String): FixedExpense
    fun getAllFixedExpensesByUserId(userId: String): List<FixedExpense>
    fun createFixedExpense(fixedExpense: FixedExpense): FixedExpense
    fun updateFixedExpense(id: String, newFixedExpense: FixedExpense): FixedExpense
    fun deleteFixedExpense(id: String)
}

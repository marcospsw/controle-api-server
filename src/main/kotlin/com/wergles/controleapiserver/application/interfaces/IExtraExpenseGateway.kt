package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.ExtraExpense

interface IExtraExpenseGateway {
    fun getExtraExpenseById(id: String): ExtraExpense
    fun getAllExtraExpensesByUserId(userId: String): List<ExtraExpense>
    fun getAllExtraExpensesByUserIdAndMonth(userId: String, month: Int): List<ExtraExpense>
    fun getAllExtraExpensesByUserIdAndYear(userId: String, year: Int): List<ExtraExpense>
    fun createExtraExpense(extraExpense: ExtraExpense): ExtraExpense
    fun updateExtraExpense(id: String, newExtraExpense: ExtraExpense): ExtraExpense
    fun deleteExtraExpense(id: String)
}

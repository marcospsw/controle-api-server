package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.Expense

interface IExpenseGateway {
    fun getExpenseById(id: String): Expense
    fun getAllExpensesByUserId(): List<Expense>
    fun getAllExpensesByUserIdAndMonth(month: Int): List<Expense>
    fun getAllExpensesByUserIdAndYear(year: Int): List<Expense>
    fun getAllExpensesByUserIdAndFixedIsTrue(): List<Expense>
    fun createExpense(expense: Expense): Expense
    fun updateExpense(id: String, newExpense: Expense): Expense
    fun deleteExpense(id: String)
}

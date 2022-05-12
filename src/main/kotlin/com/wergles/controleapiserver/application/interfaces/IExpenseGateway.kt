package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.Expense

interface IExpenseGateway {
    fun getExpenseById(id: String): Expense
    fun getAllExpensesByUserId(userId: String): List<Expense>
    fun getAllExpensesByUserIdAndMonth(userId: String, month: Int): List<Expense>
    fun getAllExpensesByUserIdAndYear(userId: String, year: Int): List<Expense>
    fun getAllExpensesByUserIdAndFixedIsTrue(userId: String): List<Expense>
    fun createExpense(expense: Expense): Expense
    fun updateExpense(id: String, newExpense: Expense): Expense
    fun deleteExpense(id: String)
}

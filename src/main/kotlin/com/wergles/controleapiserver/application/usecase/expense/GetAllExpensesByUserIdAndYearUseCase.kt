package com.wergles.controleapiserver.application.usecase.expense

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Expense

class GetAllExpensesByUserIdAndYearUseCase(private val expenseGateway: IExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(year: Int): List<Expense> {
        logger.info("GetAll ExpenseByUserAndYear UseCase -> Starting get Expenses")
        return expenseGateway.getAllExpensesByUserIdAndYear(year).also {
            logger.info("GetAll ExpenseByUserAndYear UseCase -> Successfully get Expenses")
        }
    }
}

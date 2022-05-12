package com.wergles.controleapiserver.application.usecase.expense

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Expense

class GetAllExpensesByUserIdAndFixedIsTrueUseCase(private val expenseGateway: IExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(): List<Expense> {
        logger.info("GetAll ExpensesByUserAndFixed UseCase -> Starting get Expenses")
        return expenseGateway.getAllExpensesByUserIdAndFixedIsTrue().also {
            logger.info("GetAll ExpensesByUserAndFixed UseCase -> Successfully get Expenses")
        }
    }
}

package com.wergles.controleapiserver.application.usecase.expense

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Expense

class CreateExpenseUseCase(private val expenseGateway: IExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(expense: Expense): Expense {
        logger.info("Create Expense UseCase -> Starting create Expense")
        return expenseGateway.createExpense(expense).also {
            logger.info("Create Expense UseCase -> Successfully create Expense")
        }
    }
}

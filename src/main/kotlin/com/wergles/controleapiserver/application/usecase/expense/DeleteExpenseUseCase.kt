package com.wergles.controleapiserver.application.usecase.expense

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger

class DeleteExpenseUseCase(private val expenseGateway: IExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String) {
        logger.info("Delete Expense UseCase -> Starting delete Expense")
        return expenseGateway.deleteExpense(id).also {
            logger.info("Delete Expense UseCase -> Successfully delete Expense")
        }
    }
}

package com.wergles.controleapiserver.application.usecase.expense

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Expense

class UpdateExpenseUseCase(private val expenseGateway: IExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String, newExpense: Expense): Expense {
        logger.info("Update Expense UseCase -> Starting update Expense")
        return expenseGateway.updateExpense(id, newExpense).also {
            logger.info("Update Expense UseCase -> Successfully update Expense")
        }
    }
}

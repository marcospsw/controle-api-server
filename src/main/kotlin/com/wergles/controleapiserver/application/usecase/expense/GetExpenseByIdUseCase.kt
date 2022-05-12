package com.wergles.controleapiserver.application.usecase.expense

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Expense

class GetExpenseByIdUseCase(private val expenseGateway: IExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String): Expense {
        logger.info("Get ExpenseById UseCase -> Starting get Expense")
        return expenseGateway.getExpenseById(id).also {
            logger.info("Get ExpenseById UseCase -> Successfully get Expense")
        }
    }
}

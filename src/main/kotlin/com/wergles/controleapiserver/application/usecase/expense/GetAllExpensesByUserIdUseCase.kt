package com.wergles.controleapiserver.application.usecase.expense

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Expense

class GetAllExpensesByUserIdUseCase(private val expenseGateway: IExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(): List<Expense> {
        logger.info("GetAll ExpenseByUser UseCase -> Starting get Expenses")
        return expenseGateway.getAllExpensesByUserId().also {
            logger.info("GetAll ExpenseByUser UseCase -> Successfully get Expenses")
        }
    }
}

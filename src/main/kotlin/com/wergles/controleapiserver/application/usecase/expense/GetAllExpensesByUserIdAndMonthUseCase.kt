package com.wergles.controleapiserver.application.usecase.expense

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Expense

class GetAllExpensesByUserIdAndMonthUseCase(private val expenseGateway: IExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String, month: Int): List<Expense> {
        logger.info("GetAll ExpenseByUserAndMonth UseCase -> Starting get Expenses")
        return expenseGateway.getAllExpensesByUserIdAndMonth(userId, month).also {
            logger.info("GetAll ExpenseByUserAndMonth UseCase -> Successfully get Expenses")
        }
    }
}

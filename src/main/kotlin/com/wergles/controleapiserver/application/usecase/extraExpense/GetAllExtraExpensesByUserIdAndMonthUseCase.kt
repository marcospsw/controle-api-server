package com.wergles.controleapiserver.application.usecase.extraExpense

import com.wergles.controleapiserver.application.interfaces.IExtraExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraExpense

class GetAllExtraExpensesByUserIdAndMonthUseCase(private val extraExpenseGateway: IExtraExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String, month: Int): List<ExtraExpense> {
        logger.info("GetAll ExtraExpenseByUserAndMonth UseCase -> Starting get extraExpenses")
        return extraExpenseGateway.getAllExtraExpensesByUserIdAndMonth(userId, month).also {
            logger.info("GetAll ExtraExpenseByUserAndMonth UseCase -> Successfully get extraExpenses")
        }
    }
}
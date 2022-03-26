package com.wergles.controleapiserver.application.usecase.extraExpense

import com.wergles.controleapiserver.application.interfaces.IExtraExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraExpense

class GetAllExtraExpensesByUserIdUseCase(private val extraExpenseGateway: IExtraExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String): List<ExtraExpense> {
        logger.info("GetAll ExtraExpenseByUser UseCase -> Starting get extraExpenses")
        return extraExpenseGateway.getAllExtraExpensesByUserId(userId).also {
            logger.info("GetAll ExtraExpenseByUser UseCase -> Successfully get extraExpenses")
        }
    }
}
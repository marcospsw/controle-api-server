package com.wergles.controleapiserver.application.usecase.extraExpense

import com.wergles.controleapiserver.application.interfaces.IExtraExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraExpense

class GetAllExtraExpensesByUserIdAndYearUseCase(private val extraExpenseGateway: IExtraExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String, year: Int): List<ExtraExpense> {
        logger.info("GetAll ExtraExpenseByUserAndYear UseCase -> Starting get extraExpenses")
        return extraExpenseGateway.getAllExtraExpensesByUserIdAndYear(userId, year).also {
            logger.info("GetAll ExtraExpenseByUserAndYear UseCase -> Successfully get extraExpenses")
        }
    }
}
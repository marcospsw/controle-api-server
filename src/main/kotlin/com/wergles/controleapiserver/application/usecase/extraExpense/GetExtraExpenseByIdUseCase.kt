package com.wergles.controleapiserver.application.usecase.extraExpense

import com.wergles.controleapiserver.application.interfaces.IExtraExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraExpense

class GetExtraExpenseByIdUseCase(private val extraExpenseGateway: IExtraExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String): ExtraExpense {
        logger.info("Get ExtraExpenseById UseCase -> Starting get extraExpense")
        return extraExpenseGateway.getExtraExpenseById(id).also {
            logger.info("Get ExtraExpenseById UseCase -> Successfully get extraExpense")
        }
    }
}
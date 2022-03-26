package com.wergles.controleapiserver.application.usecase.extraExpense

import com.wergles.controleapiserver.application.interfaces.IExtraExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraExpense

class CreateExtraExpenseUseCase(private val extraExpenseGateway: IExtraExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(extraExpense: ExtraExpense): ExtraExpense {
        logger.info("Create ExtraExpense UseCase -> Starting create extraExpense")
        return extraExpenseGateway.createExtraExpense(extraExpense).also {
            logger.info("Create ExtraExpense UseCase -> Successfully create extraExpense")
        }
    }
}
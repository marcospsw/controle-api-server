package com.wergles.controleapiserver.application.usecase.extraExpense

import com.wergles.controleapiserver.application.interfaces.IExtraExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraExpense

class UpdateExtraExpenseUseCase(private val extraExpenseGateway: IExtraExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String, extraExpense: ExtraExpense): ExtraExpense {
        logger.info("Update ExtraExpense UseCase -> Starting update extraExpense")
        return extraExpenseGateway.updateExtraExpense(id, extraExpense).also {
            logger.info("Update ExtraExpense UseCase -> Successfully update extraExpense")
        }
    }
}
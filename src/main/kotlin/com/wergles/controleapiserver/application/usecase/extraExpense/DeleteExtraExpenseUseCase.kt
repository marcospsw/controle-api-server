package com.wergles.controleapiserver.application.usecase.extraExpense

import com.wergles.controleapiserver.application.interfaces.IExtraExpenseGateway
import com.wergles.controleapiserver.common.Logger

class DeleteExtraExpenseUseCase(private val extraExpenseGateway: IExtraExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String) {
        logger.info("Delete ExtraExpense UseCase -> Starting delete extraExpense")
        return extraExpenseGateway.deleteExtraExpense(id).also {
            logger.info("Delete ExtraExpense UseCase -> Successfully delete extraExpense")
        }
    }
}
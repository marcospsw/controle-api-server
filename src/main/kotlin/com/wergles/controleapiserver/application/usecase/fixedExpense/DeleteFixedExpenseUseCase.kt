package com.wergles.controleapiserver.application.usecase.fixedExpense

import com.wergles.controleapiserver.application.interfaces.IFixedExpenseGateway
import com.wergles.controleapiserver.common.Logger

class DeleteFixedExpenseUseCase(private val fixedExpenseGateway: IFixedExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String) {
        logger.info("Delete FixedExpense UseCase -> Starting delete fixedExpense")
        return fixedExpenseGateway.deleteFixedExpense(id).also {
            logger.info("Delete FixedExpense UseCase -> Successfully delete fixedExpense")
        }
    }
}
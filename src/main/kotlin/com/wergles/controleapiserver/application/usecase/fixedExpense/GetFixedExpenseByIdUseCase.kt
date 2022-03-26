package com.wergles.controleapiserver.application.usecase.fixedExpense

import com.wergles.controleapiserver.application.interfaces.IFixedExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedExpense

class GetFixedExpenseByIdUseCase(private val fixedExpenseGateway: IFixedExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String): FixedExpense {
        logger.info("Get FixedExpenseById UseCase -> Starting get fixedExpense")
        return fixedExpenseGateway.getFixedExpenseById(id).also {
            logger.info("Create FixedExpenseById UseCase -> Successfully get fixedExpense")
        }
    }
}

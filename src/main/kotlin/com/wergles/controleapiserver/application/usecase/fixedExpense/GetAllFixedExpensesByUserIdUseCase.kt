package com.wergles.controleapiserver.application.usecase.fixedExpense

import com.wergles.controleapiserver.application.interfaces.IFixedExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedExpense

class GetAllFixedExpensesByUserIdUseCase(private val fixedExpenseGateway: IFixedExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String): List<FixedExpense> {
        logger.info("GetAll FixedExpenseByUser UseCase -> Starting get fixedExpenses")
        return fixedExpenseGateway.getAllFixedExpensesByUserId(userId).also {
            logger.info("GetAll FixedExpenseByUser UseCase -> Successfully get fixedExpenses")
        }
    }
}

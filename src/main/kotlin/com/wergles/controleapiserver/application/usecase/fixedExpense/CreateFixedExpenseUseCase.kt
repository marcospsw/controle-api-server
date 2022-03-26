package com.wergles.controleapiserver.application.usecase.fixedExpense

import com.wergles.controleapiserver.application.interfaces.IFixedExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedExpense

class CreateFixedExpenseUseCase(private val fixedExpenseGateway: IFixedExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(fixedExpense: FixedExpense): FixedExpense {
        logger.info("Create FixedExpense UseCase -> Starting create fixedExpense")
        return fixedExpenseGateway.createFixedExpense(fixedExpense).also {
            logger.info("Create FixedExpense UseCase -> Successfully create fixedExpense")
        }
    }
}

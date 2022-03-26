package com.wergles.controleapiserver.application.usecase.fixedExpense

import com.wergles.controleapiserver.application.interfaces.IFixedExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedExpense

class UpdateFixedExpenseUseCase(private val fixedExpenseGateway: IFixedExpenseGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String, newFixedExpense: FixedExpense): FixedExpense {
        logger.info("Update FixedExpense UseCase -> Starting update fixedExpense")
        return fixedExpenseGateway.updateFixedExpense(id, newFixedExpense).also {
            logger.info("Update FixedExpense UseCase -> Successfully update fixedExpense")
        }
    }
}

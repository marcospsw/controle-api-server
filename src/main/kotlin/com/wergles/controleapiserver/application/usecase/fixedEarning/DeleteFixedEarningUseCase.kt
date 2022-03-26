package com.wergles.controleapiserver.application.usecase.fixedEarning

import com.wergles.controleapiserver.application.interfaces.IFixedEarningGateway
import com.wergles.controleapiserver.common.Logger

class DeleteFixedEarningUseCase(private val fixedEarningGateway: IFixedEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String) {
        logger.info("Delete FixedExpense UseCase -> Starting delete fixedExpense")
        return fixedEarningGateway.deleteFixedEarning(id).also {
            logger.info("Delete FixedExpense UseCase -> Successfully delete fixedExpense")
        }
    }
}
package com.wergles.controleapiserver.application.usecase.earning

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Earning

class GetAllEarningsByUserIdUseCase(private val earningGateway: IEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String): List<Earning> {
        logger.info("GetAll EarningsByUser UseCase -> Starting get Earnings")
        return earningGateway.getAllEarningsByUserId(userId).also {
            logger.info("GetAll EarningsByUser UseCase -> Successfully get Earnings")
        }
    }
}

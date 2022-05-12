package com.wergles.controleapiserver.application.usecase.earning

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Earning

class GetAllEarningsByUserIdAndMonthUseCase(private val earningGateway: IEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String, month: Int): List<Earning> {
        logger.info("GetAll EarningsByUserAndMonth UseCase -> Starting get Earnings")
        return earningGateway.getAllEarningsByUserIdAndMonth(userId, month).also {
            logger.info("GetAll EarningsByUserAndMonth UseCase -> Successfully get Earnings")
        }
    }
}

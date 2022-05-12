package com.wergles.controleapiserver.application.usecase.earning

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Earning

class GetAllEarningsByUserIdAndYearUseCase(private val earningGateway: IEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String, year: Int): List<Earning> {
        logger.info("GetAll EarningsByUserAndYear UseCase -> Starting get Earnings")
        return earningGateway.getAllEarningsByUserIdAndYear(userId, year).also {
            logger.info("GetAll EarningsByUserAndYear UseCase -> Successfully get Earnings")
        }
    }
}

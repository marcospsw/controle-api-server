package com.wergles.controleapiserver.application.usecase.earning

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Earning

class GetAllEarningsByUserIdAndFixedIsTrueUseCase(private val earningGateway: IEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(): List<Earning> {
        logger.info("GetAll EarningsByUserAndFixed UseCase -> Starting get Earnings")
        return earningGateway.getAllEarningsByUserIdAndFixedIsTrue().also {
            logger.info("GetAll EarningsByUserAndFixed UseCase -> Successfully get Earnings")
        }
    }
}

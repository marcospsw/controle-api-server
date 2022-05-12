package com.wergles.controleapiserver.application.usecase.earning

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Earning

class CreateEarningUseCase(private val earningGateway: IEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(earning: Earning): Earning {
        logger.info("Create Earning UseCase -> Starting create Earning")
        return earningGateway.createEarning(earning).also {
            logger.info("Create Earning UseCase -> Successfully create Earning")
        }
    }
}

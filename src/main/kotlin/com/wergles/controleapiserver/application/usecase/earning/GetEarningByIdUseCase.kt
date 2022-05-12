package com.wergles.controleapiserver.application.usecase.earning

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Earning

class GetEarningByIdUseCase(private val earningGateway: IEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String): Earning {
        logger.info("Get Earning UseCase -> Starting get Earning")
        return earningGateway.getEarningById(id).also {
            logger.info("Get Earning UseCase -> Successfully get Earning")
        }
    }
}

package com.wergles.controleapiserver.application.usecase.fixedEarning

import com.wergles.controleapiserver.application.interfaces.IFixedEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedEarning

class GetFixedEarningByIdUseCase(private val fixedEarningGateway: IFixedEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String): FixedEarning {
        logger.info("Get FixedEarningById UseCase -> Starting get fixedEarning")
        return fixedEarningGateway.getFixedEarningById(id).also {
            logger.info("Get FixedEarningById UseCase -> Successfully get fixedEarning")
        }
    }
}
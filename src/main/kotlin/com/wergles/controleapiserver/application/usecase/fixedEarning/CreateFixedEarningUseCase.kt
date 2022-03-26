package com.wergles.controleapiserver.application.usecase.fixedEarning

import com.wergles.controleapiserver.application.interfaces.IFixedEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedEarning

class CreateFixedEarningUseCase(private val fixedEarningGateway: IFixedEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(fixedEarning: FixedEarning): FixedEarning {
        logger.info("Create FixedEarning UseCase -> Starting create fixedEarning")
        return fixedEarningGateway.createFixedEarning(fixedEarning).also {
            logger.info("Create FixedEarning UseCase -> Successfully create fixedEarning")
        }
    }
}
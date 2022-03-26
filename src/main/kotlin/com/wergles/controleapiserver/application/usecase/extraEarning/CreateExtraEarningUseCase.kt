package com.wergles.controleapiserver.application.usecase.extraEarning

import com.wergles.controleapiserver.application.interfaces.IExtraEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraEarning

class CreateExtraEarningUseCase(private val extraEarningGateway: IExtraEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(extraEarning: ExtraEarning): ExtraEarning {
        logger.info("Create ExtraEarning UseCase -> Starting create extraEarning")
        return extraEarningGateway.createExtraEarning(extraEarning).also {
            logger.info("Create ExtraEarning UseCase -> Successfully create extraEarning")
        }
    }
}
package com.wergles.controleapiserver.application.usecase.extraEarning

import com.wergles.controleapiserver.application.interfaces.IExtraEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraEarning

class GetExtraEarningByIdUseCase(private val extraEarningGateway: IExtraEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String): ExtraEarning {
        logger.info("Get ExtraEarning UseCase -> Starting get extraEarning")
        return extraEarningGateway.getExtraEarningById(id).also {
            logger.info("Get ExtraEarning UseCase -> Successfully get extraEarning")
        }
    }
}
package com.wergles.controleapiserver.application.usecase.extraEarning

import com.wergles.controleapiserver.application.interfaces.IExtraEarningGateway
import com.wergles.controleapiserver.common.Logger

class DeleteExtraEarningUseCase(private val extraEarningGateway: IExtraEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String) {
        logger.info("Delete ExtraEarning UseCase -> Starting delete extraEarning")
        return extraEarningGateway.deleteExtraEarning(id).also {
            logger.info("Delete ExtraEarning UseCase -> Successfully delete extraEarning")
        }
    }
}
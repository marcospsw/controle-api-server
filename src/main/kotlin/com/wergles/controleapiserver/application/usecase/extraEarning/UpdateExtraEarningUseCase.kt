package com.wergles.controleapiserver.application.usecase.extraEarning

import com.wergles.controleapiserver.application.interfaces.IExtraEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraEarning

class UpdateExtraEarningUseCase(private val extraEarningGateway: IExtraEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String, newExtraEarning: ExtraEarning): ExtraEarning {
        logger.info("Update ExtraEarning UseCase -> Starting update extraEarning")
        return extraEarningGateway.updateExtraEarning(id, newExtraEarning).also {
            logger.info("Update ExtraEarning UseCase -> Successfully update extraEarning")
        }
    }
}
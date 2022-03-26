package com.wergles.controleapiserver.application.usecase.extraEarning

import com.wergles.controleapiserver.application.interfaces.IExtraEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraEarning

class GetAllExtraEarningsByUserIdUseCase(private val extraEarningGateway: IExtraEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String): List<ExtraEarning> {
        logger.info("GetAll ExtraEarningsByUser UseCase -> Starting get extraEarnings")
        return extraEarningGateway.getAllExtraEarningsByUserId(userId).also {
            logger.info("GetAll ExtraEarningsByUser UseCase -> Successfully get extraEarnings")
        }
    }
}
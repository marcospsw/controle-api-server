package com.wergles.controleapiserver.application.usecase.extraEarning

import com.wergles.controleapiserver.application.interfaces.IExtraEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraEarning

class GetAllExtraEarningsByUserIdAndMonthUseCase(private val extraEarningGateway: IExtraEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String, month: Int): List<ExtraEarning> {
        logger.info("GetAll ExtraEarningsByUserAndMonth UseCase -> Starting get extraEarnings")
        return extraEarningGateway.getAllExtraEarningsByUserIdAndMonth(userId, month).also {
            logger.info("GetAll ExtraEarningsByUserAndMonth UseCase -> Successfully get extraEarnings")
        }
    }
}
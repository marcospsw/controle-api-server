package com.wergles.controleapiserver.application.usecase.extraEarning

import com.wergles.controleapiserver.application.interfaces.IExtraEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraEarning

class GetAllExtraEarningsByUserIdAndYearUseCase(private val extraEarningGateway: IExtraEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String, year: Int): List<ExtraEarning> {
        logger.info("GetAll ExtraEarningsByUserAndYear UseCase -> Starting get extraEarnings")
        return extraEarningGateway.getAllExtraEarningsByUserIdAndYear(userId, year).also {
            logger.info("GetAll ExtraEarningsByUserAndYear UseCase -> Successfully get extraEarnings")
        }
    }
}
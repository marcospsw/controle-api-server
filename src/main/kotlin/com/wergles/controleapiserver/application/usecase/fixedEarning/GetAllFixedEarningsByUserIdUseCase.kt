package com.wergles.controleapiserver.application.usecase.fixedEarning

import com.wergles.controleapiserver.application.interfaces.IFixedEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedEarning

class GetAllFixedEarningsByUserIdUseCase(private val fixedEarningGateway: IFixedEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(userId: String): List<FixedEarning> {
        logger.info("GetAll FixedEarningByUser UseCase -> Starting get fixedEarnings")
        return fixedEarningGateway.getAllFixedEarningsByUserId(userId).also {
            logger.info("GetAll FixedEarningByUser UseCase -> Successfully get fixedEarnings")
        }
    }
}
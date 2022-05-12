package com.wergles.controleapiserver.application.usecase.earning

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Earning

class UpdateEarningUseCase(private val earningGateway: IEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String, newEarning: Earning): Earning {
        logger.info("Update Earning UseCase -> Starting update Earning")
        return earningGateway.updateEarning(id, newEarning).also {
            logger.info("Update Earning UseCase -> Successfully update Earning")
        }
    }
}

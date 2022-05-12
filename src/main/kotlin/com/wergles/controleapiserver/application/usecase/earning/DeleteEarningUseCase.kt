package com.wergles.controleapiserver.application.usecase.earning

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger

class DeleteEarningUseCase(private val earningGateway: IEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String) {
        logger.info("Delete Earning UseCase -> Starting delete Earning")
        return earningGateway.deleteEarning(id).also {
            logger.info("Delete Earning UseCase -> Successfully delete Earning")
        }
    }
}

package com.wergles.controleapiserver.application.usecase.fixedEarning

import com.wergles.controleapiserver.application.interfaces.IFixedEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedEarning

class UpdateFixedEarningUseCase(private val fixedEarningGateway: IFixedEarningGateway) {
    private val logger = Logger(this.javaClass)

    fun execute(id: String, fixedEarning: FixedEarning): FixedEarning {
        logger.info("Update FixedEarning UseCase -> Starting update fixedEarning")
        return fixedEarningGateway.updateFixedEarning(id, fixedEarning).also {
            logger.info("Update FixedEarning UseCase -> Successfully update fixedEarning")
        }
    }
}
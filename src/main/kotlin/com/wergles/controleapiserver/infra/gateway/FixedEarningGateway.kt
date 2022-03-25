package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IFixedEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedEarning
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.model.FixedEarningDocument
import com.wergles.controleapiserver.infra.gateway.repository.FixedEarningRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FixedEarningGateway(
    private val fixedEarningsRepository: FixedEarningRepository
) : IFixedEarningGateway {
    val logger = Logger(this.javaClass)

    override fun getFixedEarningById(id: String): FixedEarning {
        logger.info("FixedEarning Gateway -> Starting get fixedEarningById")
        return fixedEarningsRepository.findByIdOrNull(id)?.toDomain().also {
            logger.info("FixedEarning Gateway -> Successfully get fixedEarningById")
        } ?: throw NotFoundException("FixedEarning as not found")
    }

    override fun getAllFixedEarningsByUserId(userId: String): List<FixedEarning> {
        logger.info("FixedEarning Gateway -> Starting get fixedEarningByUser")
        return fixedEarningsRepository.getAllByUserId(userId)?.map {
            it.toDomain()
        }.also {
            logger.info("FixedEarning Gateway -> Successfully get fixedEarningById")
        } ?: throw NotFoundException("FixedEarning as not found")
    }

    override fun createFixedEarning(fixedEarning: FixedEarning): FixedEarning {
        logger.info("FixedEarning Gateway -> Starting create fixedEarning")
        return fixedEarningsRepository.save(FixedEarningDocument(fixedEarning)).toDomain().also {
            logger.info("FixedEarning Gateway -> Successfully create fixedEarning")
        }
    }

    override fun updateFixedEarning(id: String, newFixedEarning: FixedEarning): FixedEarning {
        logger.info("FixedEarning Gateway -> Starting edit fixedEarning")
        val fixedEarning = fixedEarningsRepository.findByIdOrNull(id)
            .also { logger.info("FixedEarning Gateway -> Successfully get fixedEarning") }
            ?: throw NotFoundException("FixedEarning as not found")
        return fixedEarningsRepository.save(
            fixedEarning.copy(
                title = newFixedEarning.title,
                description = newFixedEarning.description,
                value = newFixedEarning.value,
                updated_at = LocalDateTime.now()
            )
        ).toDomain()
            .also { logger.info("FixedEarning Gateway -> Successfully edit fixedEarning") }
    }

    override fun deleteFixedEarning(id: String) {
        logger.info("FixedEarning Gateway -> Starting delete fixedEarning")
        fixedEarningsRepository.deleteById(id)
            .also { logger.info("FixedEarning Gateway -> Successfully delete fixedEarning") }
    }
}

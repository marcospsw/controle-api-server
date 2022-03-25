package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IExtraEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraEarning
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.model.ExtraEarningDocument
import com.wergles.controleapiserver.infra.gateway.repository.ExtraEarningRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ExtraEarningGateway(
    private val extraEarningRepository: ExtraEarningRepository
) : IExtraEarningGateway {
    val logger = Logger(this.javaClass)

    override fun getExtraEarningById(id: String): ExtraEarning {
        logger.info("ExtraEarning Gateway -> Starting get extraEarningById")
        return extraEarningRepository.findByIdOrNull(id)?.toDomain().also {
            logger.info("ExtraEarning Gateway -> Successfully get extraEarningById")
        } ?: throw NotFoundException("ExtraEarning as not found")
    }

    override fun getAllExtraEarningsByUserId(userId: String): List<ExtraEarning> {
        logger.info("ExtraEarning Gateway -> Starting get extraEarningsByUserId")
        return extraEarningRepository.getAllByUserId(userId)?.map {
            it.toDomain()
        }.also {
            logger.info("ExtraEarning Gateway -> Successfully get extraEarningsByUserId")
        } ?: throw NotFoundException("ExtraExpense as not found")
    }

    override fun getAllExtraEarningsByUserIdAndMonth(userId: String, month: Int): List<ExtraEarning> {
        logger.info("ExtraEarning Gateway -> Starting get extraEarningsByUserIdAndMonth")
        return extraEarningRepository.getAllByUserIdAndMonth(userId, month)?.map {
            it.toDomain()
        }.also {
            logger.info("ExtraEarning Gateway -> Successfully get extraEarningsByUserIdAndMonth")
        } ?: throw NotFoundException("ExtraEarning as not found")
    }

    override fun getAllExtraEarningsByUserIdAndYear(userId: String, year: Int): List<ExtraEarning> {
        logger.info("ExtraEarning Gateway -> Starting get extraEarningsByUserIdAndYear")
        return extraEarningRepository.getAllByUserIdAndYear(userId, year)?.map {
            it.toDomain()
        }.also {
            logger.info("ExtraEarning Gateway -> Successfully get extraEarningsByUserIdAndYear")
        } ?: throw NotFoundException("ExtraEarning as not found")
    }

    override fun createExtraEarning(extraEarning: ExtraEarning): ExtraEarning {
        logger.info("ExtraEarning Gateway -> Starting create extraEarning")
        return extraEarningRepository.save(ExtraEarningDocument(extraEarning)).toDomain().also {
            logger.info("ExtraEarning Gateway -> Successfully create extraEarning")
        }
    }

    override fun updateExtraEarning(id: String, newExtraEarning: ExtraEarning): ExtraEarning {
        logger.info("ExtraEarning Gateway -> Starting edit extraEarning")
        val extraEarning = extraEarningRepository.findByIdOrNull(id)
            .also { logger.info("ExtraEarning Gateway -> Successfully get extraEarningById") }
            ?: throw NotFoundException("ExtraEarning as not found")
        return extraEarningRepository.save(
            extraEarning.copy(
                title = newExtraEarning.title,
                description = newExtraEarning.description,
                month = newExtraEarning.month,
                year = newExtraEarning.year,
                value = newExtraEarning.value,
                updated_at = LocalDateTime.now()
            )
        ).toDomain()
            .also { logger.info("ExtraEarning Gateway -> Successfully edit extraEarning") }
    }

    override fun deleteExtraEarning(id: String) {
        logger.info("ExtraEarning Gateway -> Starting delete extraEarning")
        extraEarningRepository.deleteById(id)
            .also { logger.info("ExtraEarning Gateway -> Successfully delete extraEarning") }
    }
}

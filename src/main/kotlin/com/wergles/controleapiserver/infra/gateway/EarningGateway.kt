package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IEarningGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Earning
import com.wergles.controleapiserver.domain.exception.BusinessException
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.model.EarningDocument
import com.wergles.controleapiserver.infra.gateway.repository.EarningRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EarningGateway(
    private val earningRepository: EarningRepository,
    private val userGateway: UserGateway
) : IEarningGateway {
    val logger = Logger(this.javaClass)

    override fun getEarningById(id: String): Earning {
        logger.info("Earning Gateway -> Starting get EarningById")
        return earningRepository.findByIdOrNull(id)?.toDomain().also {
            logger.info("Earning Gateway -> Successfully get EarningById")
        } ?: throw NotFoundException("Earning as not found")
    }

    override fun getAllEarningsByUserId(): List<Earning> {
        logger.info("Earning Gateway -> Starting get EarningsByUserId")
        val userId = userGateway.getAuthenticatedUserId()
        return earningRepository.getAllByUserId(userId)?.map {
            it.toDomain()
        }.also {
            logger.info("Earning Gateway -> Successfully get EarningsByUserId")
        } ?: throw NotFoundException("Earnings as not found")
    }

    override fun getAllEarningsByUserIdAndMonth(month: Int): List<Earning> {
        logger.info("Earning Gateway -> Starting get EarningsByUserIdAndMonth")
        val userId = userGateway.getAuthenticatedUserId()
        return earningRepository.getAllByUserIdAndMonth(userId, month)?.map {
            it.toDomain()
        }.also {
            logger.info("Earning Gateway -> Successfully get EarningsByUserIdAndMonth")
        } ?: throw NotFoundException("Earnings as not found")
    }

    override fun getAllEarningsByUserIdAndYear(year: Int): List<Earning> {
        logger.info("Earning Gateway -> Starting get EarningsByUserIdAndYear")
        val userId = userGateway.getAuthenticatedUserId()
        return earningRepository.getAllByUserIdAndYear(userId, year)?.map {
            it.toDomain()
        }.also {
            logger.info("Earning Gateway -> Successfully get EarningsByUserIdAndYear")
        } ?: throw NotFoundException("Earnings as not found")
    }

    override fun getAllEarningsByUserIdAndFixedIsTrue(): List<Earning> {
        logger.info("Earning Gateway -> Starting get EarningsByUserIdAndFixed")
        val userId = userGateway.getAuthenticatedUserId()
        return earningRepository.getAllByUserIdAndFixedIsTrue(userId)?.map {
            it.toDomain()
        }.also {
            logger.info("Earning Gateway -> Successfully get EarningsByUserIdAndFixed")
        } ?: throw NotFoundException("Earnings as not found")
    }

    override fun createEarning(earning: Earning): Earning {
        logger.info("Earning Gateway -> Starting create Earning")
        if (!earning.fixed && (earning.month == null || earning.year == null))
            throw BusinessException("Earning is not fixed, month and year it can not be null")

        return earningRepository.save(EarningDocument(earning)).toDomain().also {
            logger.info("Earning Gateway -> Successfully create Earning")
        }
    }

    override fun updateEarning(id: String, newEarning: Earning): Earning {
        logger.info("Earning Gateway -> Starting edit Earning")
        if (!newEarning.fixed && (newEarning.month == null || newEarning.year == null))
            throw BusinessException("Earning is not fixed, month and year it can not be null")

        val earning = earningRepository.findByIdOrNull(id)
            .also { logger.info("Earning Gateway -> Successfully get EarningById") }
            ?: throw NotFoundException("Earning as not found")
        return earningRepository.save(
            earning.copy(
                title = newEarning.title,
                description = newEarning.description,
                month = newEarning.month,
                year = newEarning.year,
                value = newEarning.value,
                updated_at = LocalDateTime.now()
            )
        ).toDomain()
            .also { logger.info("Earning Gateway -> Successfully edit Earning") }
    }

    override fun deleteEarning(id: String) {
        logger.info("Earning Gateway -> Starting delete Earning")
        earningRepository.deleteById(id)
            .also { logger.info("Earning Gateway -> Successfully delete Earning") }
    }
}

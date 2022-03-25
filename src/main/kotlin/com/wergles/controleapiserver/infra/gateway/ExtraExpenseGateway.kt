package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IExtraExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.ExtraExpense
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.model.ExtraExpenseDocument
import com.wergles.controleapiserver.infra.gateway.repository.ExtraExpenseRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ExtraExpenseGateway(
    private val extraExpensesRepository: ExtraExpenseRepository
) : IExtraExpenseGateway {
    val logger = Logger(this.javaClass)

    override fun getExtraExpenseById(id: String): ExtraExpense {
        logger.info("ExtraExpense Gateway -> Starting get extraExpenseById")
        return extraExpensesRepository.findByIdOrNull(id)?.toDomain().also {
            logger.info("ExtraExpense Gateway -> Successfully get extraExpenseById")
        } ?: throw NotFoundException("ExtraExpense as not found")
    }

    override fun getAllExtraExpensesByUserId(userId: String): List<ExtraExpense> {
        logger.info("ExtraExpense Gateway -> Starting get extraExpenseById")
        return extraExpensesRepository.getAllByUserId(userId)?.map {
            it.toDomain()
        }.also {
            logger.info("ExtraExpense Gateway -> Successfully get extraExpenseById")
        } ?: throw NotFoundException("ExtraExpense as not found")
    }

    override fun getAllExtraExpensesByUserIdAndMonth(userId: String, month: Int): List<ExtraExpense> {
        logger.info("ExtraExpense Gateway -> Starting get extraExpenseByUserIdAndMonth")
        return extraExpensesRepository.getAllByUserIdAndMonth(userId, month)?.map {
            it.toDomain()
        }.also {
            logger.info("ExtraExpense Gateway -> Successfully get extraExpenseByUserIdAndMonth")
        } ?: throw NotFoundException("ExtraExpense as not found")
    }

    override fun getAllExtraExpensesByUserIdAndYear(userId: String, year: Int): List<ExtraExpense> {
        logger.info("ExtraExpense Gateway -> Starting get extraExpenseByUserIdAndYear")
        return extraExpensesRepository.getAllByUserIdAndYear(userId, year)?.map {
            it.toDomain()
        }.also {
            logger.info("ExtraExpense Gateway -> Successfully get extraExpenseByUserIdAndYear")
        } ?: throw NotFoundException("ExtraExpense as not found")
    }

    override fun createExtraExpense(extraExpense: ExtraExpense): ExtraExpense {
        logger.info("ExtraExpense Gateway -> Starting create extraExpense")
        return extraExpensesRepository.save(ExtraExpenseDocument(extraExpense)).toDomain().also {
            logger.info("ExtraExpense Gateway -> Successfully create extraExpense")
        }
    }

    override fun updateExtraExpense(id: String, newExtraExpense: ExtraExpense): ExtraExpense {
        logger.info("ExtraExpense Gateway -> Starting edit extraExpenseById")
        val extraExpense = extraExpensesRepository.findByIdOrNull(id)
            .also { logger.info("ExtraExpense Gateway -> Successfully get extraExpenseById") }
            ?: throw NotFoundException("ExtraExpense as not found")
        return extraExpensesRepository.save(
            extraExpense.copy(
                title = newExtraExpense.title,
                description = newExtraExpense.description,
                month = newExtraExpense.month,
                year = newExtraExpense.year,
                value = newExtraExpense.value,
                updated_at = LocalDateTime.now()
            )
        ).toDomain()
            .also { logger.info("ExtraExpense Gateway -> Successfully edit extraExpense") }
    }

    override fun deleteExtraExpense(id: String) {
        logger.info("ExtraExpense Gateway -> Starting delete extraExpense")
        extraExpensesRepository.deleteById(id)
            .also { logger.info("ExtraExpense Gateway -> Successfully delete extraExpense") }
    }
}

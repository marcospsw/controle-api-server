package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IFixedExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.FixedExpense
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.model.FixedExpenseDocument
import com.wergles.controleapiserver.infra.gateway.repository.FixedExpenseRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FixedExpenseGateway(
    private val fixedExpensesRepository: FixedExpenseRepository,
) : IFixedExpenseGateway {
    val logger = Logger(this.javaClass)

    override fun getFixedExpenseById(id: String): FixedExpense {
        logger.info("FixedExpense Gateway -> Starting get fixedExpenseById")
        return fixedExpensesRepository.findByIdOrNull(id)?.toDomain().also {
            logger.info("FixedExpense Gateway -> Successfully get fixedExpenseById")
        } ?: throw NotFoundException("FixedExpense as not found")
    }

    override fun getAllFixedExpensesByUserId(userId: String): List<FixedExpense> {
        logger.info("FixedExpense Gateway -> Starting get fixedExpenseByUser")
        return fixedExpensesRepository.getAllByUserId(userId)?.map {
            it.toDomain()
        }.also {
            logger.info("FixedExpense Gateway -> Successfully get fixedExpenseByUser")
        } ?: throw NotFoundException("FixedExpense as not found")
    }

    override fun createFixedExpense(fixedExpense: FixedExpense): FixedExpense {
        logger.info("FixedExpense Gateway -> Starting create fixedExpense")
        return fixedExpensesRepository.save(FixedExpenseDocument(fixedExpense)).toDomain().also {
            logger.info("FixedExpense Gateway -> Successfully create fixedExpense")
        }
    }

    override fun updateFixedExpense(id: String, newFixedExpense: FixedExpense): FixedExpense {
        logger.info("FixedExpense Gateway -> Starting edit fixedExpense")
        val fixedExpense = fixedExpensesRepository.findByIdOrNull(id)
            .also { logger.info("FixedExpense Gateway -> Successfully get fixedExpense") }
            ?: throw NotFoundException("FixedExpense as not found")
        return fixedExpensesRepository.save(
            fixedExpense.copy(
                title = newFixedExpense.title,
                description = newFixedExpense.description,
                value = newFixedExpense.value,
                updated_at = LocalDateTime.now()
            )
        ).toDomain()
            .also { logger.info("FixedExpense Gateway -> Successfully edit fixedExpense") }
    }

    override fun deleteFixedExpense(id: String) {
        logger.info("FixedExpense Gateway -> Starting delete fixedExpense")
        fixedExpensesRepository.deleteById(id)
            .also { logger.info("FixedExpense Gateway -> Successfully delete fixedExpense") }
    }
}

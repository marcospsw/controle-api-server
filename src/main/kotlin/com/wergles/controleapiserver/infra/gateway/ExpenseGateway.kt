package com.wergles.controleapiserver.infra.gateway

import com.wergles.controleapiserver.application.interfaces.IExpenseGateway
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.domain.entity.Expense
import com.wergles.controleapiserver.domain.exception.BusinessException
import com.wergles.controleapiserver.domain.exception.NotFoundException
import com.wergles.controleapiserver.infra.gateway.model.ExpenseDocument
import com.wergles.controleapiserver.infra.gateway.repository.ExpenseRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ExpenseGateway(
    private val expensesRepository: ExpenseRepository
) : IExpenseGateway {
    val logger = Logger(this.javaClass)

    override fun getExpenseById(id: String): Expense {
        logger.info("Expense Gateway -> Starting get ExpenseById")
        return expensesRepository.findByIdOrNull(id)?.toDomain().also {
            logger.info("Expense Gateway -> Successfully get ExpenseById")
        } ?: throw NotFoundException("Expense as not found")
    }

    override fun getAllExpensesByUserId(userId: String): List<Expense> {
        logger.info("Expense Gateway -> Starting get ExpenseById")
        return expensesRepository.getAllByUserId(userId)?.map {
            it.toDomain()
        }.also {
            logger.info("Expense Gateway -> Successfully get ExpenseById")
        } ?: throw NotFoundException("Expenses as not found")
    }

    override fun getAllExpensesByUserIdAndMonth(userId: String, month: Int): List<Expense> {
        logger.info("Expense Gateway -> Starting get ExpenseByUserIdAndMonth")
        return expensesRepository.getAllByUserIdAndMonth(userId, month)?.map {
            it.toDomain()
        }.also {
            logger.info("Expense Gateway -> Successfully get ExpenseByUserIdAndMonth")
        } ?: throw NotFoundException("Expenses as not found")
    }

    override fun getAllExpensesByUserIdAndYear(userId: String, year: Int): List<Expense> {
        logger.info("Expense Gateway -> Starting get ExpenseByUserIdAndYear")
        return expensesRepository.getAllByUserIdAndYear(userId, year)?.map {
            it.toDomain()
        }.also {
            logger.info("Expense Gateway -> Successfully get ExpenseByUserIdAndYear")
        } ?: throw NotFoundException("Expenses as not found")
    }

    override fun getAllExpensesByUserIdAndFixedIsTrue(userId: String): List<Expense> {
        logger.info("Expense Gateway -> Starting get ExpenseByUserIdAndFixed")
        return expensesRepository.getAllByUserIdAndFixedIsTrue(userId)?.map {
            it.toDomain()
        }.also {
            logger.info("Expense Gateway -> Successfully get ExpenseByUserIdAndFixed")
        } ?: throw NotFoundException("Expenses as not found")
    }

    override fun createExpense(expense: Expense): Expense {
        logger.info("Expense Gateway -> Starting create Expense")
        if (!expense.fixed && (expense.month == null || expense.year == null))
            throw BusinessException("Expense is not fixed, month and year it can not be null")

        return expensesRepository.save(ExpenseDocument(expense)).toDomain().also {
            logger.info("Expense Gateway -> Successfully create Expense")
        }
    }

    override fun updateExpense(id: String, newExpense: Expense): Expense {
        logger.info("Expense Gateway -> Starting edit ExpenseById")
        if (!newExpense.fixed && (newExpense.month == null || newExpense.year == null))
            throw BusinessException("Expense is not fixed, month and year it can not be null")

        val expense = expensesRepository.findByIdOrNull(id)
            .also { logger.info("Expense Gateway -> Successfully get ExpenseById") }
            ?: throw NotFoundException("Expense as not found")
        return expensesRepository.save(
            expense.copy(
                title = newExpense.title,
                description = newExpense.description,
                month = newExpense.month,
                year = newExpense.year,
                value = newExpense.value,
                updated_at = LocalDateTime.now()
            )
        ).toDomain()
            .also { logger.info("Expense Gateway -> Successfully edit Expense") }
    }

    override fun deleteExpense(id: String) {
        logger.info("Expense Gateway -> Starting delete Expense")
        expensesRepository.deleteById(id)
            .also { logger.info("Expense Gateway -> Successfully delete Expense") }
    }
}

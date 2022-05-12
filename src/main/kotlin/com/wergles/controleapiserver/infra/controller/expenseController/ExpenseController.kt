package com.wergles.controleapiserver.infra.controller.expenseController

import com.wergles.controleapiserver.application.usecase.expense.*
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.expenseController.dto.CreateExpenseRequestDTO
import com.wergles.controleapiserver.infra.controller.expenseController.dto.ExpenseResponseDTO
import com.wergles.controleapiserver.infra.controller.expenseController.dto.UpdateExpenseRequestDTO
import com.wergles.controleapiserver.infra.controller.expenseController.dto.toResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/expense")
class ExpenseController(
    private val createExpenseUseCase: CreateExpenseUseCase,
    private val deleteExpenseUseCase: DeleteExpenseUseCase,
    private val updateExpenseUseCase: UpdateExpenseUseCase,
    private val getExpenseByIdUseCase: GetExpenseByIdUseCase,
    private val getAllExpensesByUserIdUseCase: GetAllExpensesByUserIdUseCase,
    private val getAllExpensesByUserIdAndMonthUseCase: GetAllExpensesByUserIdAndMonthUseCase,
    private val getAllExpensesByUserIdAndYearUseCase: GetAllExpensesByUserIdAndYearUseCase,
    private val getAllExpensesByUserIdAndFixedIsTrueUseCase: GetAllExpensesByUserIdAndFixedIsTrueUseCase
) {
    private val logger = Logger(this.javaClass)

    @GetMapping
    fun getAllExpensesByUser(): List<ExpenseResponseDTO> {
        logger.info("Expense Controller -> Starting finding Expenses")
        return getAllExpensesByUserIdUseCase.execute().map { it.toResponse() }.also {
            logger.info("Expense Controller -> Successfully finding Expenses")
        }
    }

    @GetMapping("/{id}")
    fun getExpenseById(@PathVariable("id") id: String): ExpenseResponseDTO {
        logger.info("Expense Controller -> Starting finding Expense")
        return getExpenseByIdUseCase.execute(id).toResponse().also {
            logger.info("Expense Controller -> Successfully finding Expense")
        }
    }

    @GetMapping("/month/{month}")
    fun getAllExpensesByUserAndMonth(
        @PathVariable("month") month: Int
    ): List<ExpenseResponseDTO> {
        logger.info("Expense Controller -> Starting finding Expenses")
        return getAllExpensesByUserIdAndMonthUseCase.execute(month).map { it.toResponse() }.also {
            logger.info("Expense Controller -> Successfully finding Expenses")
        }
    }

    @GetMapping("/year/{year}")
    fun getAllExpensesByUserAndYear(
        @PathVariable("year") year: Int
    ): List<ExpenseResponseDTO> {
        logger.info("Expense Controller -> Starting finding Expenses")
        return getAllExpensesByUserIdAndYearUseCase.execute(year).map { it.toResponse() }.also {
            logger.info("Expense Controller -> Successfully finding Expenses")
        }
    }

    @GetMapping("/fixed")
    fun getAllExpensesByUserAndFixed(): List<ExpenseResponseDTO> {
        logger.info("Expense Controller -> Starting finding Expenses")
        return getAllExpensesByUserIdAndFixedIsTrueUseCase.execute().map { it.toResponse() }.also {
            logger.info("Expense Controller -> Successfully finding Expenses")
        }
    }

    @PostMapping("/create")
    fun createExpense(@RequestBody ExpenseRequest: CreateExpenseRequestDTO): ExpenseResponseDTO {
        logger.info("Expense Controller -> Starting create Expense")
        return createExpenseUseCase.execute(ExpenseRequest.toDomain()).toResponse().also {
            logger.info("Expense Controller -> Successfully create Expense")
        }
    }

    @PutMapping("/{id}")
    fun updateExpense(
        @PathVariable("id") id: String,
        @RequestBody ExpenseRequest: UpdateExpenseRequestDTO
    ): ExpenseResponseDTO {
        logger.info("Expense Controller -> Starting update Expense")
        return updateExpenseUseCase.execute(id, ExpenseRequest.toDomain()).toResponse().also {
            logger.info("Expense Controller -> Successfully update Expense")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteExpense(@PathVariable("id") id: String) {
        logger.info("Expense Controller -> Starting delete Expense")
        return deleteExpenseUseCase.execute(id).also {
            logger.info("Expense Controller -> Successfully delete Expense")
        }
    }
}

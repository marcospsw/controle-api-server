package com.wergles.controleapiserver.infra.controller.extraExpenseController

import com.wergles.controleapiserver.application.usecase.extraExpense.*
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.extraExpenseController.dto.CreateExtraExpenseRequestDTO
import com.wergles.controleapiserver.infra.controller.extraExpenseController.dto.ExtraExpenseResponseDTO
import com.wergles.controleapiserver.infra.controller.extraExpenseController.dto.UpdateExtraExpenseRequestDTO
import com.wergles.controleapiserver.infra.controller.extraExpenseController.dto.toResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/extraExpense")
class ExtraExpenseController(
    private val createExtraExpenseUseCase: CreateExtraExpenseUseCase,
    private val deleteExtraExpenseUseCase: DeleteExtraExpenseUseCase,
    private val updateExtraExpenseUseCase: UpdateExtraExpenseUseCase,
    private val getExtraExpenseByIdUseCase: GetExtraExpenseByIdUseCase,
    private val getAllExtraExpensesByUserIdUseCase: GetAllExtraExpensesByUserIdUseCase,
    private val getAllExtraExpensesByUserIdAndMonthUseCase: GetAllExtraExpensesByUserIdAndMonthUseCase,
    private val getAllExtraExpensesByUserIdAndYearUseCase: GetAllExtraExpensesByUserIdAndYearUseCase
) {
    private val logger = Logger(this.javaClass)

    @GetMapping("/{id}")
    fun getExtraExpense(@PathVariable("id") id: String): ExtraExpenseResponseDTO {
        logger.info("ExtraExpense Controller -> Starting finding extraExpense")
        return getExtraExpenseByIdUseCase.execute(id).toResponse().also {
            logger.info("ExtraExpense Controller -> Successfully finding extraExpense")
        }
    }

    @GetMapping("/{userId}")
    fun getAllExtraExpensesByUser(@PathVariable("userId") userId: String): List<ExtraExpenseResponseDTO> {
        logger.info("ExtraExpense Controller -> Starting finding extraExpenses")
        return getAllExtraExpensesByUserIdUseCase.execute(userId).map { it.toResponse() }.also {
            logger.info("ExtraExpense Controller -> Successfully finding extraExpenses")
        }
    }

    @GetMapping("/{userId}/{month}")
    fun getAllExtraExpensesByUserAndMonth(
        @PathVariable("userId") userId: String, @PathVariable("month") month: Int
    ): List<ExtraExpenseResponseDTO> {
        logger.info("ExtraExpense Controller -> Starting finding extraExpenses")
        return getAllExtraExpensesByUserIdAndMonthUseCase.execute(userId, month).map { it.toResponse() }.also {
            logger.info("ExtraExpense Controller -> Successfully finding extraExpenses")
        }
    }

    @GetMapping("/{userId}/{year}")
    fun getAllExtraExpensesByUserAndYear(
        @PathVariable("userId") userId: String, @PathVariable("year") year: Int
    ): List<ExtraExpenseResponseDTO> {
        logger.info("ExtraExpense Controller -> Starting finding extraExpenses")
        return getAllExtraExpensesByUserIdAndYearUseCase.execute(userId, year).map { it.toResponse() }.also {
            logger.info("ExtraExpense Controller -> Successfully finding extraExpenses")
        }
    }

    @PostMapping("/create")
    fun createExtraExpense(@RequestBody extraExpenseRequest: CreateExtraExpenseRequestDTO): ExtraExpenseResponseDTO {
        logger.info("ExtraExpense Controller -> Starting create extraExpense")
        return createExtraExpenseUseCase.execute(extraExpenseRequest.toDomain()).toResponse().also {
            logger.info("ExtraExpense Controller -> Successfully create extraExpense")
        }
    }

    @PutMapping("/{id}")
    fun updateExtraExpense(
        @PathVariable("id") id: String, @RequestBody extraExpenseRequest: UpdateExtraExpenseRequestDTO
    ): ExtraExpenseResponseDTO {
        logger.info("ExtraExpense Controller -> Starting update extraExpense")
        return updateExtraExpenseUseCase.execute(id, extraExpenseRequest.toDomain()).toResponse().also {
            logger.info("ExtraExpense Controller -> Successfully update extraExpense")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteExtraExpense(@PathVariable("id") id: String) {
        logger.info("ExtraExpense Controller -> Starting delete extraExpense")
        return deleteExtraExpenseUseCase.execute(id).also {
            logger.info("ExtraExpense Controller -> Successfully delete extraExpense")
        }
    }
}
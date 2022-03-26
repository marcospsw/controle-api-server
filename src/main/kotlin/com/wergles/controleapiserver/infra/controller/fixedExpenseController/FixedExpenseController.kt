package com.wergles.controleapiserver.infra.controller.fixedExpenseController

import com.wergles.controleapiserver.application.usecase.fixedExpense.*
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.fixedExpenseController.dto.CreateFixedExpenseRequestDTO
import com.wergles.controleapiserver.infra.controller.fixedExpenseController.dto.FixedExpenseResponseDTO
import com.wergles.controleapiserver.infra.controller.fixedExpenseController.dto.UpdateFixedExpenseRequestDTO
import com.wergles.controleapiserver.infra.controller.fixedExpenseController.dto.toResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fixedExpense")
class FixedExpenseController(
    private val createFixedExpenseUseCase: CreateFixedExpenseUseCase,
    private val deleteFixedExpenseUseCase: DeleteFixedExpenseUseCase,
    private val updateFixedExpenseUseCase: UpdateFixedExpenseUseCase,
    private val getFixedExpenseByIdUseCase: GetFixedExpenseByIdUseCase,
    private val getAllFixedExpensesByUserIdUseCase: GetAllFixedExpensesByUserIdUseCase,
) {
    private val logger = Logger(this.javaClass)

    @GetMapping("/{id}")
    fun getFixedExpense(@PathVariable("id") id: String): FixedExpenseResponseDTO {
        logger.info("FixedExpense Controller -> Starting finding fixedExpense")
        return getFixedExpenseByIdUseCase.execute(id).toResponse().also {
            logger.info("FixedExpense Controller -> Successfully finding fixedExpense")
        }
    }

    @GetMapping("/{userId}")
    fun getAllFixedExpensesByUser(@PathVariable("userId") userId: String): List<FixedExpenseResponseDTO> {
        logger.info("FixedExpense Controller -> Starting finding fixedExpenses")
        return getAllFixedExpensesByUserIdUseCase.execute(userId).map { it.toResponse() }.also {
            logger.info("FixedExpense Controller -> Successfully finding fixedExpenses")
        }
    }

    @PostMapping("/create")
    fun createFixedExpense(@RequestBody fixedExpenseRequest: CreateFixedExpenseRequestDTO): FixedExpenseResponseDTO {
        logger.info("FixedExpense Controller -> Starting create fixedExpense")
        return createFixedExpenseUseCase.execute(fixedExpenseRequest.toDomain()).toResponse().also {
            logger.info("FixedExpense Controller -> Successfully create fixedExpense")
        }
    }

    @PutMapping("/{id}")
    fun updateFixedExpense(
        @PathVariable("id") id: String, @RequestBody fixedExpenseRequest: UpdateFixedExpenseRequestDTO
    ): FixedExpenseResponseDTO {
        logger.info("FixedExpense Controller -> Starting update fixedExpense")
        return updateFixedExpenseUseCase.execute(id, fixedExpenseRequest.toDomain()).toResponse().also {
            logger.info("FixedExpense Controller -> Successfully update fixedExpense")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteFixedExpense(@PathVariable("id") id: String) {
        logger.info("FixedExpense Controller -> Starting delete fixedExpense")
        return deleteFixedExpenseUseCase.execute(id).also {
            logger.info("FixedExpense Controller -> Successfully delete fixedExpense")
        }
    }
}

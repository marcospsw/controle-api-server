package com.wergles.controleapiserver.infra.controller.earningController

import com.wergles.controleapiserver.application.usecase.earning.*
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.earningController.dto.CreateEarningRequestDTO
import com.wergles.controleapiserver.infra.controller.earningController.dto.EarningResponseDTO
import com.wergles.controleapiserver.infra.controller.earningController.dto.UpdateEarningRequestDTO
import com.wergles.controleapiserver.infra.controller.earningController.dto.toResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/earning")
class EarningController(
    private val createEarningUseCase: CreateEarningUseCase,
    private val deleteEarningUseCase: DeleteEarningUseCase,
    private val updateEarningUseCase: UpdateEarningUseCase,
    private val getEarningByIdUseCase: GetEarningByIdUseCase,
    private val getAllEarningsByUserIdUseCase: GetAllEarningsByUserIdUseCase,
    private val getAllEarningsByUserIdAndMonthUseCase: GetAllEarningsByUserIdAndMonthUseCase,
    private val getAllEarningsByUserIdAndYearUseCase: GetAllEarningsByUserIdAndYearUseCase,
    private val getAllEarningsByUserIdAndFixedIsTrueUseCase: GetAllEarningsByUserIdAndFixedIsTrueUseCase
) {
    private val logger = Logger(this.javaClass)

    @GetMapping("/{id}")
    fun getEarning(@PathVariable("id") id: String): EarningResponseDTO {
        logger.info("Earning Controller -> Starting finding Earning")
        return getEarningByIdUseCase.execute(id).toResponse().also {
            logger.info("Earning Controller -> Successfully finding Earning")
        }
    }

    @GetMapping("/{userId}")
    fun getEarningByUser(@PathVariable("userId") userId: String): List<EarningResponseDTO> {
        logger.info("Earning Controller -> Starting finding Earnings")
        return getAllEarningsByUserIdUseCase.execute(userId).map { it.toResponse() }.also {
            logger.info("Earning Controller -> Successfully finding Earnings")
        }
    }

    @GetMapping("/{userId}/{month}")
    fun getAllEarningByUserAndMonth(
        @PathVariable("userId") userId: String,
        @PathVariable("month") month: Int
    ): List<EarningResponseDTO> {
        logger.info("Earning Controller -> Starting finding Earnings")
        return getAllEarningsByUserIdAndMonthUseCase.execute(userId, month).map { it.toResponse() }.also {
            logger.info("Earning Controller -> Successfully finding Earnings")
        }
    }

    @GetMapping("/{userId}/{year}")
    fun getAllEarningByUserAndYear(
        @PathVariable("userId") userId: String,
        @PathVariable("year") year: Int
    ): List<EarningResponseDTO> {
        logger.info("Earning Controller -> Starting finding Earnings")
        return getAllEarningsByUserIdAndYearUseCase.execute(userId, year).map { it.toResponse() }.also {
            logger.info("Earning Controller -> Successfully finding Earnings")
        }
    }

    @GetMapping("/{userId}/fixed")
    fun getAllEarningByUserAndFixed(
        @PathVariable("userId") userId: String,
    ): List<EarningResponseDTO> {
        logger.info("Earning Controller -> Starting finding Earnings")
        return getAllEarningsByUserIdAndFixedIsTrueUseCase.execute(userId).map { it.toResponse() }.also {
            logger.info("Earning Controller -> Successfully finding Earnings")
        }
    }

    @PostMapping("/create")
    fun createEarning(@RequestBody EarningRequest: CreateEarningRequestDTO): EarningResponseDTO {
        logger.info("Earning Controller -> Starting create Earning")
        return createEarningUseCase.execute(EarningRequest.toDomain()).toResponse().also {
            logger.info("Earning Controller -> Successfully create Earning")
        }
    }

    @PutMapping("/{id}")
    fun updateEarning(
        @PathVariable("id") id: String,
        @RequestBody EarningRequest: UpdateEarningRequestDTO
    ): EarningResponseDTO {
        logger.info("Earning Controller -> Starting update Earning")
        return updateEarningUseCase.execute(id, EarningRequest.toDomain()).toResponse().also {
            logger.info("Earning Controller -> Successfully update Earning")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteEarning(@PathVariable("id") id: String) {
        logger.info("Earning Controller -> Starting delete Earning")
        return deleteEarningUseCase.execute(id).also {
            logger.info("Earning Controller -> Successfully delete Earning")
        }
    }
}

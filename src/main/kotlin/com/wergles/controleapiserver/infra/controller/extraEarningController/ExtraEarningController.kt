package com.wergles.controleapiserver.infra.controller.extraEarningController

import com.wergles.controleapiserver.application.usecase.extraEarning.*
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.extraEarningController.dto.CreateExtraEarningRequestDTO
import com.wergles.controleapiserver.infra.controller.extraEarningController.dto.ExtraEarningResponseDTO
import com.wergles.controleapiserver.infra.controller.extraEarningController.dto.UpdateExtraEarningRequestDTO
import com.wergles.controleapiserver.infra.controller.extraEarningController.dto.toResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/extraEarning")
class ExtraEarningController(
    private val createExtraEarningUseCase: CreateExtraEarningUseCase,
    private val deleteExtraEarningUseCase: DeleteExtraEarningUseCase,
    private val updateExtraEarningUseCase: UpdateExtraEarningUseCase,
    private val getExtraEarningByIdUseCase: GetExtraEarningByIdUseCase,
    private val getAllExtraEarningsByUserIdUseCase: GetAllExtraEarningsByUserIdUseCase,
    private val getAllExtraEarningsByUserIdAndMonthUseCase: GetAllExtraEarningsByUserIdAndMonthUseCase,
    private val getAllExtraEarningsByUserIdAndYearUseCase: GetAllExtraEarningsByUserIdAndYearUseCase
) {
    private val logger = Logger(this.javaClass)

    @GetMapping("/{id}")
    fun getFixedEarning(@PathVariable("id") id: String): ExtraEarningResponseDTO {
        logger.info("ExtraEarning Controller -> Starting finding extraEarning")
        return getExtraEarningByIdUseCase.execute(id).toResponse().also {
            logger.info("ExtraEarning Controller -> Successfully finding extraEarning")
        }
    }

    @GetMapping("/{userId}")
    fun getAllFixedEarningByUser(@PathVariable("userId") userId: String): List<ExtraEarningResponseDTO> {
        logger.info("ExtraEarning Controller -> Starting finding extraEarnings")
        return getAllExtraEarningsByUserIdUseCase.execute(userId).map { it.toResponse() }.also {
            logger.info("ExtraEarning Controller -> Successfully finding extraEarnings")
        }
    }

    @GetMapping("/{userId}/{month}")
    fun getAllFixedEarningByUserAndMonth(
        @PathVariable("userId") userId: String, @PathVariable("month") month: Int
    ): List<ExtraEarningResponseDTO> {
        logger.info("ExtraEarning Controller -> Starting finding extraEarnings")
        return getAllExtraEarningsByUserIdAndMonthUseCase.execute(userId, month).map { it.toResponse() }.also {
            logger.info("ExtraEarning Controller -> Successfully finding extraEarnings")
        }
    }

    @GetMapping("/{userId}/{year}")
    fun getAllFixedEarningByUserAndYear(
        @PathVariable("userId") userId: String, @PathVariable("year") year: Int
    ): List<ExtraEarningResponseDTO> {
        logger.info("ExtraEarning Controller -> Starting finding extraEarnings")
        return getAllExtraEarningsByUserIdAndYearUseCase.execute(userId, year).map { it.toResponse() }.also {
            logger.info("ExtraEarning Controller -> Successfully finding extraEarnings")
        }
    }

    @PostMapping("/create")
    fun createFixedEarning(@RequestBody extraEarningRequest: CreateExtraEarningRequestDTO): ExtraEarningResponseDTO {
        logger.info("ExtraEarning Controller -> Starting create extraEarning")
        return createExtraEarningUseCase.execute(extraEarningRequest.toDomain()).toResponse().also {
            logger.info("ExtraEarning Controller -> Successfully create extraEarning")
        }
    }

    @PutMapping("/{id}")
    fun updateFixedEarning(
        @PathVariable("id") id: String, @RequestBody extraEarningRequest: UpdateExtraEarningRequestDTO
    ): ExtraEarningResponseDTO {
        logger.info("ExtraEarning Controller -> Starting update extraEarning")
        return updateExtraEarningUseCase.execute(id, extraEarningRequest.toDomain()).toResponse().also {
            logger.info("ExtraEarning Controller -> Successfully update extraEarning")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteFixedEarning(@PathVariable("id") id: String) {
        logger.info("ExtraEarning Controller -> Starting delete extraEarning")
        return deleteExtraEarningUseCase.execute(id).also {
            logger.info("ExtraEarning Controller -> Successfully delete extraEarning")
        }
    }

}

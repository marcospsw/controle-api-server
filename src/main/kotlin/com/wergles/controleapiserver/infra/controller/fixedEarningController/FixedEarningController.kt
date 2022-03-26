package com.wergles.controleapiserver.infra.controller.fixedEarningController

import com.wergles.controleapiserver.application.usecase.fixedEarning.*
import com.wergles.controleapiserver.common.Logger
import com.wergles.controleapiserver.infra.controller.fixedEarningController.dto.CreateFixedEarningRequestDTO
import com.wergles.controleapiserver.infra.controller.fixedEarningController.dto.FixedEarningResponseDTO
import com.wergles.controleapiserver.infra.controller.fixedEarningController.dto.UpdateFixedEarningRequestDTO
import com.wergles.controleapiserver.infra.controller.fixedEarningController.dto.toResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fixedEarning")
class FixedEarningController(
    private val createFixedEarningUseCase: CreateFixedEarningUseCase,
    private val deleteFixedEarningUseCase: DeleteFixedEarningUseCase,
    private val updateFixedEarningUseCase: UpdateFixedEarningUseCase,
    private val getFixedEarningByIdUseCase: GetFixedEarningByIdUseCase,
    private val getAllFixedEarningsByUserIdUseCase: GetAllFixedEarningsByUserIdUseCase,
) {
    private val logger = Logger(this.javaClass)

    @GetMapping("/{id}")
    fun getFixedEarning(@PathVariable("id") id: String): FixedEarningResponseDTO {
        logger.info("FixedEarning Controller -> Starting finding fixedEarning")
        return getFixedEarningByIdUseCase.execute(id).toResponse().also {
            logger.info("FixedEarning Controller -> Successfully finding fixedEarning")
        }
    }

    @GetMapping("/{userId}")
    fun getAllFixedEarningsByUser(@PathVariable("userId") userId: String): List<FixedEarningResponseDTO> {
        logger.info("FixedEarning Controller -> Starting finding fixedEarning")
        return getAllFixedEarningsByUserIdUseCase.execute(userId).map { it.toResponse() }.also {
            logger.info("FixedEarning Controller -> Successfully finding fixedEarning")
        }
    }

    @PostMapping("/create")
    fun createFixedEarning(@RequestBody fixedEarningRequest: CreateFixedEarningRequestDTO): FixedEarningResponseDTO {
        logger.info("FixedEarning Controller -> Starting create fixedEarning")
        return createFixedEarningUseCase.execute(fixedEarningRequest.toDomain()).toResponse().also {
            logger.info("FixedEarning Controller -> Successfully create fixedEarning")
        }
    }

    @PutMapping("/{id}")
    fun updateFixedEarning(
        @PathVariable("id") id: String, @RequestBody fixedEarningRequest: UpdateFixedEarningRequestDTO
    ): FixedEarningResponseDTO {
        logger.info("FixedEarning Controller -> Starting update fixedEarning")
        return updateFixedEarningUseCase.execute(id, fixedEarningRequest.toDomain()).toResponse().also {
            logger.info("FixedEarning Controller -> Successfully update fixedEarning")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteFixedEarning(@PathVariable("id") id: String) {
        logger.info("FixedEarning Controller -> Starting delete fixedEarning")
        return deleteFixedEarningUseCase.execute(id).also {
            logger.info("FixedEarning Controller -> Successfully delete fixedEarning")
        }
    }

}

package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.FixedEarning

interface IFixedEarningGateway {
    fun getFixedEarningById(id: String): FixedEarning
    fun getAllFixedEarningsByUserId(userId: String): List<FixedEarning>
    fun createFixedEarning(fixedEarning: FixedEarning): FixedEarning
    fun updateFixedEarning(id: String, newFixedEarning: FixedEarning): FixedEarning
    fun deleteFixedEarning(id: String)
}

package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.ExtraEarning

interface IExtraEarningGateway {
    fun getExtraEarningById(id: String): ExtraEarning
    fun getAllExtraEarningsByUserId(userId: String): List<ExtraEarning>
    fun getAllExtraEarningsByUserIdAndMonth(userId: String, month: Int): List<ExtraEarning>
    fun getAllExtraEarningsByUserIdAndYear(userId: String, year: Int): List<ExtraEarning>
    fun createExtraEarning(extraEarning: ExtraEarning): ExtraEarning
    fun updateExtraEarning(id: String, newExtraEarning: ExtraEarning): ExtraEarning
    fun deleteExtraEarning(id: String)
}

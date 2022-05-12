package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.Earning

interface IEarningGateway {
    fun getEarningById(id: String): Earning
    fun getAllEarningsByUserId(): List<Earning>
    fun getAllEarningsByUserIdAndMonth(month: Int): List<Earning>
    fun getAllEarningsByUserIdAndYear(year: Int): List<Earning>
    fun getAllEarningsByUserIdAndFixedIsTrue(): List<Earning>
    fun createEarning(earning: Earning): Earning
    fun updateEarning(id: String, newEarning: Earning): Earning
    fun deleteEarning(id: String)
}

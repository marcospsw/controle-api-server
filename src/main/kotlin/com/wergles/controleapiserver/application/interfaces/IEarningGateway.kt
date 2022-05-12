package com.wergles.controleapiserver.application.interfaces

import com.wergles.controleapiserver.domain.entity.Earning

interface IEarningGateway {
    fun getEarningById(id: String): Earning
    fun getAllEarningsByUserId(userId: String): List<Earning>
    fun getAllEarningsByUserIdAndMonth(userId: String, month: Int): List<Earning>
    fun getAllEarningsByUserIdAndYear(userId: String, year: Int): List<Earning>
    fun getAllEarningsByUserIdAndFixedIsTrue(userId: String): List<Earning>
    fun createEarning(earning: Earning): Earning
    fun updateEarning(id: String, newEarning: Earning): Earning
    fun deleteEarning(id: String)
}

package com.wergles.controleapiserver.application.config

import com.wergles.controleapiserver.application.usecase.earning.*
import com.wergles.controleapiserver.application.usecase.expense.*
import com.wergles.controleapiserver.application.usecase.user.CreateUserUseCase
import com.wergles.controleapiserver.application.usecase.user.DeleteUserUseCase
import com.wergles.controleapiserver.application.usecase.user.GetUserByIdUseCase
import com.wergles.controleapiserver.application.usecase.user.UpdateUserUseCase
import com.wergles.controleapiserver.infra.gateway.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfig {
    @Bean
    fun createUserUseCase(userGateway: UserGateway) = CreateUserUseCase(userGateway = userGateway)

    @Bean
    fun getUserByIdUseCase(userGateway: UserGateway) = GetUserByIdUseCase(userGateway = userGateway)

    @Bean
    fun updateUserUseCase(userGateway: UserGateway) = UpdateUserUseCase(userGateway = userGateway)

    @Bean
    fun deleteUserUseCase(userGateway: UserGateway) = DeleteUserUseCase(userGateway = userGateway)

    @Bean
    fun createEarningUseCase(earningGateway: EarningGateway) =
        CreateEarningUseCase(earningGateway = earningGateway)

    @Bean
    fun deleteEarningUseCase(earningGateway: EarningGateway) =
        DeleteEarningUseCase(earningGateway = earningGateway)

    @Bean
    fun updateEarningUseCase(earningGateway: EarningGateway) =
        UpdateEarningUseCase(earningGateway = earningGateway)

    @Bean
    fun getEarningByIdUseCase(earningGateway: EarningGateway) =
        GetEarningByIdUseCase(earningGateway = earningGateway)

    @Bean
    fun getAllEarningsByUserIdUseCase(earningGateway: EarningGateway) =
        GetAllEarningsByUserIdUseCase(earningGateway = earningGateway)

    @Bean
    fun getAllEarningsByUserIdAndMonthUseCase(earningGateway: EarningGateway) =
        GetAllEarningsByUserIdAndMonthUseCase(earningGateway = earningGateway)

    @Bean
    fun getAllEarningsByUserIdAndYearUseCase(earningGateway: EarningGateway) =
        GetAllEarningsByUserIdAndYearUseCase(earningGateway = earningGateway)

    @Bean
    fun getAllEarningsByUserIdAndFixedIsTrueUseCase(earningGateway: EarningGateway) =
        GetAllEarningsByUserIdAndFixedIsTrueUseCase(earningGateway = earningGateway)

    @Bean
    fun createExpenseUseCase(expenseGateway: ExpenseGateway) =
        CreateExpenseUseCase(expenseGateway = expenseGateway)

    @Bean
    fun deleteExpenseUseCase(expenseGateway: ExpenseGateway) =
        DeleteExpenseUseCase(expenseGateway = expenseGateway)

    @Bean
    fun updateExpenseUseCase(expenseGateway: ExpenseGateway) =
        UpdateExpenseUseCase(expenseGateway = expenseGateway)

    @Bean
    fun getExpenseByIdUseCase(expenseGateway: ExpenseGateway) =
        GetExpenseByIdUseCase(expenseGateway = expenseGateway)

    @Bean
    fun getAllExpensesByUserIdUseCase(expenseGateway: ExpenseGateway) =
        GetAllExpensesByUserIdUseCase(expenseGateway = expenseGateway)

    @Bean
    fun getAllExpensesByUserIdAndMonthUseCase(expenseGateway: ExpenseGateway) =
        GetAllExpensesByUserIdAndMonthUseCase(expenseGateway = expenseGateway)

    @Bean
    fun getAllExpensesByUserIdAndYearUseCase(expenseGateway: ExpenseGateway) =
        GetAllExpensesByUserIdAndYearUseCase(expenseGateway = expenseGateway)

    @Bean
    fun getAllExpensesByUserIdAndFixedIsTrueUseCase(expenseGateway: ExpenseGateway) =
        GetAllExpensesByUserIdAndFixedIsTrueUseCase(expenseGateway = expenseGateway)
}

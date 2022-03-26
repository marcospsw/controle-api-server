package com.wergles.controleapiserver.application.config

import com.wergles.controleapiserver.application.usecase.extraEarning.*
import com.wergles.controleapiserver.application.usecase.extraExpense.*
import com.wergles.controleapiserver.application.usecase.fixedEarning.*
import com.wergles.controleapiserver.application.usecase.fixedExpense.*
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
    fun createFixedExpenseUseCase(fixedExpenseGateway: FixedExpenseGateway) =
        CreateFixedExpenseUseCase(fixedExpenseGateway = fixedExpenseGateway)

    @Bean
    fun deleteFixedExpenseUseCase(fixedExpenseGateway: FixedExpenseGateway) =
        DeleteFixedExpenseUseCase(fixedExpenseGateway = fixedExpenseGateway)

    @Bean
    fun updateFixedExpenseUseCase(fixedExpenseGateway: FixedExpenseGateway) =
        UpdateFixedExpenseUseCase(fixedExpenseGateway = fixedExpenseGateway)

    @Bean
    fun getFixedExpenseByIdUseCase(fixedExpenseGateway: FixedExpenseGateway) =
        GetFixedExpenseByIdUseCase(fixedExpenseGateway = fixedExpenseGateway)

    @Bean
    fun getAllFixedExpensesByUserIdUseCase(fixedExpenseGateway: FixedExpenseGateway) =
        GetAllFixedExpensesByUserIdUseCase(fixedExpenseGateway = fixedExpenseGateway)

    @Bean
    fun createFixedEarningUseCase(fixedEarningGateway: FixedEarningGateway) =
        CreateFixedEarningUseCase(fixedEarningGateway = fixedEarningGateway)

    @Bean
    fun deleteFixedEarningUseCase(fixedEarningGateway: FixedEarningGateway) =
        DeleteFixedEarningUseCase(fixedEarningGateway = fixedEarningGateway)

    @Bean
    fun updateFixedEarningUseCase(fixedEarningGateway: FixedEarningGateway) =
        UpdateFixedEarningUseCase(fixedEarningGateway = fixedEarningGateway)

    @Bean
    fun getFixedEarningByIdUseCase(fixedEarningGateway: FixedEarningGateway) =
        GetFixedEarningByIdUseCase(fixedEarningGateway = fixedEarningGateway)

    @Bean
    fun getAllFixedEarningsByUserIdUseCase(fixedEarningGateway: FixedEarningGateway) =
        GetAllFixedEarningsByUserIdUseCase(fixedEarningGateway = fixedEarningGateway)

    @Bean
    fun createExtraEarningUseCase(extraEarningGateway: ExtraEarningGateway) =
        CreateExtraEarningUseCase(extraEarningGateway = extraEarningGateway)

    @Bean
    fun deleteExtraEarningUseCase(extraEarningGateway: ExtraEarningGateway) =
        DeleteExtraEarningUseCase(extraEarningGateway = extraEarningGateway)

    @Bean
    fun updateExtraEarningUseCase(extraEarningGateway: ExtraEarningGateway) =
        UpdateExtraEarningUseCase(extraEarningGateway = extraEarningGateway)

    @Bean
    fun getExtraEarningByIdUseCase(extraEarningGateway: ExtraEarningGateway) =
        GetExtraEarningByIdUseCase(extraEarningGateway = extraEarningGateway)

    @Bean
    fun getAllExtraEarningsByUserIdUseCase(extraEarningGateway: ExtraEarningGateway) =
        GetAllExtraEarningsByUserIdUseCase(extraEarningGateway = extraEarningGateway)

    @Bean
    fun getAllExtraEarningsByUserIdAndMonthUseCase(extraEarningGateway: ExtraEarningGateway) =
        GetAllExtraEarningsByUserIdAndMonthUseCase(extraEarningGateway = extraEarningGateway)

    @Bean
    fun getAllExtraEarningsByUserIdAndYearUseCase(extraEarningGateway: ExtraEarningGateway) =
        GetAllExtraEarningsByUserIdAndYearUseCase(extraEarningGateway = extraEarningGateway)

    @Bean
    fun createExtraExpenseUseCase(extraExpenseGateway: ExtraExpenseGateway) =
        CreateExtraExpenseUseCase(extraExpenseGateway = extraExpenseGateway)

    @Bean
    fun deleteExtraExpenseUseCase(extraExpenseGateway: ExtraExpenseGateway) =
        DeleteExtraExpenseUseCase(extraExpenseGateway = extraExpenseGateway)

    @Bean
    fun updateExtraExpenseUseCase(extraExpenseGateway: ExtraExpenseGateway) =
        UpdateExtraExpenseUseCase(extraExpenseGateway = extraExpenseGateway)

    @Bean
    fun getExtraExpenseByIdUseCase(extraExpenseGateway: ExtraExpenseGateway) =
        GetExtraExpenseByIdUseCase(extraExpenseGateway = extraExpenseGateway)

    @Bean
    fun getAllExtraExpensesByUserIdUseCase(extraExpenseGateway: ExtraExpenseGateway) =
        GetAllExtraExpensesByUserIdUseCase(extraExpenseGateway = extraExpenseGateway)

    @Bean
    fun getAllExtraExpensesByUserIdAndMonthUseCase(extraExpenseGateway: ExtraExpenseGateway) =
        GetAllExtraExpensesByUserIdAndMonthUseCase(extraExpenseGateway = extraExpenseGateway)

    @Bean
    fun getAllExtraExpensesByUserIdAndYearUseCase(extraExpenseGateway: ExtraExpenseGateway) =
        GetAllExtraExpensesByUserIdAndYearUseCase(extraExpenseGateway = extraExpenseGateway)


}

package br.com.fundatec.fundatecheroti22.login.di

import br.com.fundatec.fundatecheroti22.login.data.repository.LoginRepository
import br.com.fundatec.fundatecheroti22.login.data.repository.LoginRepositoryImpl
import br.com.fundatec.fundatecheroti22.login.domain.LoginUseCase
import br.com.fundatec.fundatecheroti22.login.domain.LoginUseCaseImpl
import br.com.fundatec.fundatecheroti22.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val loginModule = module {
    factoryOf(::LoginUseCaseImpl) { bind<LoginUseCase>() }
    factoryOf(::LoginRepositoryImpl) { bind<LoginRepository>() }
    viewModelOf(::LoginViewModel)
}
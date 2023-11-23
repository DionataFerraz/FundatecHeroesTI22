package br.com.fundatec.fundatecheroti22.profile.di

import br.com.fundatec.fundatecheroti22.profile.presentation.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val profileModule = module {
    viewModelOf(::ProfileViewModel)
}
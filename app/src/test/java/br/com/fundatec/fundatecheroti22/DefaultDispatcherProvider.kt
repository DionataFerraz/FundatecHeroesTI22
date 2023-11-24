package br.com.fundatec.fundatecheroti22

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

open class DefaultDispatcherProvider {
    open fun main(): CoroutineDispatcher = Dispatchers.Main
    open fun default(): CoroutineDispatcher = Dispatchers.Default
    open fun io(): CoroutineDispatcher = Dispatchers.IO
    open fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}
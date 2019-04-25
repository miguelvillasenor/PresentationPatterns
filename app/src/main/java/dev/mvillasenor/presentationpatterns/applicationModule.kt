package dev.mvillasenor.presentationpatterns

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module

const val IO_DISPATCHER = "IO"
const val MAIN_DISPATCHER = "MAIN"

val applicationModule = module {

    single<CoroutineDispatcher>(name = IO_DISPATCHER) { Dispatchers.Main }
    single<CoroutineDispatcher>(name = MAIN_DISPATCHER) { Dispatchers.IO }

}

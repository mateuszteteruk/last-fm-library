package pl.mateuszteteruk.core.domain.interactor

interface BaseInteractor<Input, Output> {

    suspend fun execute(input: Input): Output
}
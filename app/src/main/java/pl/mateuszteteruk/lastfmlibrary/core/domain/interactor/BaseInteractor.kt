package pl.mateuszteteruk.lastfmlibrary.core.domain.interactor

interface BaseInteractor<Input, Output> {

    suspend fun execute(input: Input): Output
}
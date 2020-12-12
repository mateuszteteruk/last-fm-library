package pl.mateuszteteruk.lastfmlibrary.core.domain

interface BaseInteractor<Input, Output> {

    suspend fun execute(input: Input): Output
}
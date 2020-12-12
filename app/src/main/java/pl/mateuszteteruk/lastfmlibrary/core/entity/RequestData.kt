package pl.mateuszteteruk.lastfmlibrary.core.entity

data class RequestData(
    val perPage: Int,
    val page: Int,
    val period: Period
)
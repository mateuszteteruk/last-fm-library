package pl.mateuszteteruk.lastfmlibrary.core.entity

data class RequestData(
    val page: Int = 1,
    val perPage: Int = 20,
    val period: Period = Period.Overall
)
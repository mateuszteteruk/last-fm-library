package pl.mateuszteteruk.lastfmlibrary.core.domain.entity

enum class Period(val key: String) {
    Overall("overall"),
    Week("7day"),
    Month1("1month"),
    Month3("3month"),
    Month6("6month"),
    Month12("12month")
}
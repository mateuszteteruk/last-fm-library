package pl.mateuszteteruk.lastfmlibrary.core.entity

data class Image(
    val type: Type,
    val url: String
) {

    enum class Type {
        Small, Medium, Large, ExtraLarge;

        companion object {

            fun resolve(name: String): Type =
                when (name) {
                    "small" -> Type.Small
                    "medium" -> Type.Medium
                    "large" -> Type.Large
                    "extralarge" -> Type.ExtraLarge
                    else -> Type.Medium
                }
        }

    }
}
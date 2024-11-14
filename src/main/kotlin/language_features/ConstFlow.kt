package language_features

const val IMG = ".img"

class SomeConsts {
    companion object {
        val fileName: String
            get() = "abs$IMG"
    }
}
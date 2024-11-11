package language_features

abstract class Tree {
    abstract val name: String
    abstract fun transformName()
    open fun namePlus() = "$name plus"
    fun nameLowerCase() = name.lowercase()
}
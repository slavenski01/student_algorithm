package koltin_patterns_book

import java.net.URL

private data class CatImage(
    val thumbnailUrl: String,
    val url: String
) {
    //только при первом обращении будет выполнена загрузка,
    // при последующих будет просто ссылка на полученное значение
    val image: ByteArray by lazy {
        URL(url).readBytes()
    }
}
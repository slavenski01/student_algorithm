package koltin_patterns_book.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun main() {
    val t1 = measureTimeMillis {
        Blocking.profile("123")
    }
    val t2 = measureTimeMillis {
        Async().profile("123")
    }

    println("Blocking code: $t1")
    println("Async: $t2")
}

private class Profile(
    val friends: List<String>,
    val picture: ByteArray? = null,
    val bio: String,
) {
    override fun toString(): String {
        return "friends: $friends, picture: $picture, bio: $bio"
    }
}

private class Async {
    val scope = CoroutineScope(Dispatchers.Default)
    suspend fun profile(id: String): Profile {
        val friends = withContext(Dispatchers.IO) {
            fetchFriendsFromDB(id)
        }
        val picture = withContext(Dispatchers.IO) {
            fetchPictureFromDB(id)
        }
        val bio = withContext(Dispatchers.IO) {
            fetchBioOverHttp(id)
        }
        return Profile(
            friends = friends.await(),
            picture = picture.await(),
            bio = bio.await()
        )
    }

    private suspend fun fetchFriendsFromDB(id: String) = coroutineScope {
        async {
            delay(500)
            emptyList<String>()
        }
    }

    private fun fetchPictureFromDB(id: String) = scope.async {
        delay(100)
        null
    }

    private fun fetchBioOverHttp(id: String) = scope.async {
        delay(1000)
        "Alexey Soshin, Software Architect"
    }
}

private class Blocking {
    companion object {
        fun profile(id: String): Profile {
            val bio = fetchBioOverHttp(id) // занимает 1 секунду
            val picture = fetchPictureFromDB(id) // занимает 100 миллисекунд
            val friends = fetchFriendsFromDB(id) // занимает 500 миллисекунд
            return Profile(friends = friends, picture = picture, bio = bio)
        }

        private fun fetchFriendsFromDB(id: String): List<String> {
            Thread.sleep(500)
            return emptyList()
        }

        private fun fetchPictureFromDB(id: String): ByteArray? {
            Thread.sleep(100)
            return null
        }

        private fun fetchBioOverHttp(id: String): String {
            Thread.sleep(1000)
            return "Alexey Soshin, Software Architect"
        }
    }
}

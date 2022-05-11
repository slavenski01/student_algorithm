package pattern_book.rmi

import java.rmi.server.UnicastRemoteObject

class MyRemoteImpl: UnicastRemoteObject(), MyRemote {

    override fun sayHello(): String {
        return "Server says, 'Hey'"
    }

    companion object {
        private const val SerialVersionUID = 1L
    }
}
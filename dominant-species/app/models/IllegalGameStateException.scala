package models

import java.lang.RuntimeException

class IllegalGameStateException(message: String, cause: Throwable = null)
    extends RuntimeException(message, cause) {

}
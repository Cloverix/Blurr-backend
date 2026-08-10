import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

@ControllerAdvice
class UserExceptionHandler {
    fun handleUserNotFound(e: UserNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND);
    }

    fun handleUserAlreadyRegistered(e: UserAlreadyRegisteredException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST);
    }
}
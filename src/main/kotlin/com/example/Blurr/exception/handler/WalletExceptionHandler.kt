import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

@ControllerAdvice
class WalletExceptionHandler {
    fun walletNotFoundHandler(e: WalletNotFoundException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND);
    }
}
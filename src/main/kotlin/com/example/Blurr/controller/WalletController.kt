import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/wallets")
class WalletController {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<WalletResponseDto> {

    }

    @GetMapping("/byUserId")
    fun getByUserId(@RequestParam(name = "userId") userId: Long): ResponseEntity<List<WalletResponseDto>> {

    }

    @GetMapping("/search")
    fun getByNameIncluding(
        @RequestParam(name = "userId") userId: Long,
        @RequestParam(name = "nameIncluding") nameIncluding: String
    ): ResponseEntity<List<WalletResponseDto>> {

    }

    @PostMapping
    fun post(@RequestBody dto: WalletCreateDto): ResponseEntity<WalletResponseDto> {
        
    }

    @PatchMapping("/{id}/update")
    fun update(
        @PathVariable id: Long,
        @RequestBody updateDto: WalletUpdateDto
    ): ResponseEntity<WalletResponseDto> {

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        
    }
}
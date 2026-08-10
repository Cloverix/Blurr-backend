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
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/api/wallets")
class WalletController(
    private val walletService: WalletService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<WalletResponseDto> {
        return ResponseEntity.ok(walletService.getById(id));
    }

    @GetMapping("/byUserId")
    fun getByUserId(@RequestParam(name = "userId") userId: Long): ResponseEntity<List<WalletResponseDto>> {
        return ResponseEntity.ok(walletService.getByUserId(userId));
    }

    @GetMapping("/search")
    fun getByNameIncluding(
        @RequestParam(name = "userId") userId: Long,
        @RequestParam(name = "nameIncluding") nameIncluding: String
    ): ResponseEntity<List<WalletResponseDto>> {
        return ResponseEntity.ok(walletService.getByNameIncluding(userId, nameIncluding));
    }

    @PostMapping
    fun post(@RequestBody dto: WalletCreateDto): ResponseEntity<WalletResponseDto> {
        return ResponseEntity(walletService.post(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody updateDto: WalletUpdateDto
    ): ResponseEntity<WalletResponseDto> {
        return ResponseEntity.ok(walletService.update(id, updateDto));
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity(walletService.deleteById(id), HttpStatus.NO_CONTENT);
    }
}
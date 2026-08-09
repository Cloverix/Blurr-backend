import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/transactions")
class TransactionController {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<TransactionResponseDto> {

    }

    @GetMapping("/byWalletId")
    fun getByWalletId(
        @RequestParam(name = "walletId") walletId: Long
    ): ResponseEntity<List<TransactionResponseDto>> {

    }

    @GetMapping("/byGoalId")
    fun getByGoalId(
        @RequestParam(name = "goalId") goalId: Long
    ): ResponseEntity<List<TransactionResponseDto>> {

    }

    @GetMapping("/byType")
    fun getByType(
        @RequestParam(name = "userId") userId: Long,
        @RequestParam(name = "type") type: String
    ): ResponseEntity<List<TransactionResponseDto>> {

    }

    @GetMapping("/byCategory")
    fun getByCategory(
        @RequestParam(name = "userId") userId: Long,
        @RequestParam(name = "category") category: String
    ): ResponseEntity<List<TransactionResponseDto>> {

    }

    @PostMapping
    fun post(@RequestBody dto: TransactionCreateDto): ResponseEntity<TransactionResponseDto> {

    }

    @PatchMapping("/{id}/update")
    fun update(
        @PathVariable id: Long,
        @RequestBody updateDto: TransactionUpdateDto
    ): ResponseEntity<TransactionResponseDto> {

    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        
    }
}
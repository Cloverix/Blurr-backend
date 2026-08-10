import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/api/goals")
class GoalController(
    private val goalService: GoalService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<GoalResponseDto> {
        return ResponseEntity.ok(goalService.getById(id));
    }

    @GetMapping("/byUserId")
    fun getByUserId(@RequestParam(name = "userId") userId: Long): ResponseEntity<List<GoalResponseDto>> {
        return ResponseEntity.ok(goalService.getByUserId(userId));
    }

    @GetMapping("/search")
    fun getByNameIncluding(
        @RequestParam(name = "userId") userId: Long,
        @RequestParam(name = "nameIncluding") nameIncluding: String
    ): ResponseEntity<List<GoalResponseDto>> {
        return ResponseEntity.ok(goalService.getByNameIncluding(userId, nameIncluding));
    }

    @GetMapping("/byStatus")
    fun getByStatus(
        @RequestParam(name = "userId") userId: Long,
        @RequestParam(name = "status") status: String
    ): ResponseEntity<List<GoalResponseDto>> {
        return ResponseEntity.ok(goalService.getByStatus(userId, status));
    }

    //Get user's goals that have reminder function enabled
    @GetMapping("/sendReminders")
    fun getSendReminders(@RequestParam(name = "userId") userId: Long): ResponseEntity<List<GoalResponseDto>> {
        return ResponseEntity.ok(goalService.getSendReminders(userId));
    }

    @PostMapping
    fun post(@RequestBody dto: GoalCreateDto): ResponseEntity<GoalResponseDto> {
        return ResponseEntity(goalService.post(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody updateDto: GoalUpdateDto
    ): ResponseEntity<GoalResponseDto> {
        return ResponseEntity.ok(goalService.update(id, updateDto));
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        return ResponseEntity(goalService.deleteById(id), HttpStatus.NO_CONTENT);
    }
}
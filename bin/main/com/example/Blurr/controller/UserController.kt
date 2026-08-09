import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/users")
class UserController {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserResponseDto> {

    }

    @PostMapping("/register")
    fun register(@RequestBody dto: UserRegisterDto): ResponseEntity<UserResponseDto> {

    }

    @PatchMapping("/{id}/update")
    fun update(
        @PathVariable id: Long,
        @RequestBody updateDto: UserUpdateDto
    ): ResponseEntity<UserResponseDto> {
        
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {

    }
}
package DistributedSystem.ticketsystem;

import DistributedSystem.ticketsystem.domain.book.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "version 1.0";
    }
}

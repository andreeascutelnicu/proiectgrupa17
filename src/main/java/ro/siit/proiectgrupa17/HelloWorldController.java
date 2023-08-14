package ro.siit.proiectgrupa17;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @PostMapping(value = "/hi")
    public String sayHi() {
        return "Hello world";
    }

    @GetMapping(value = "/bye")
    public String sayBye() {
        return "Good night";
    }
}

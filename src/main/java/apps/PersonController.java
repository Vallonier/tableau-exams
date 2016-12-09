package apps;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/person")
    public Person greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Person(counter.incrementAndGet(),
                String.format(template, name));
    }
}

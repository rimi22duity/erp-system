package maks.erp.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duity
 * @since 5/4/24
 */

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }
}

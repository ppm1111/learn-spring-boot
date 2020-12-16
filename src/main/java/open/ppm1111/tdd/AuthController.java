package open.ppm1111.tdd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class AuthController {
    
    private final Logger logger = LoggerFactory.getLogger("ppm1111.log");
    
    @GetMapping("/a")
    @PreAuthorize("hasAnyAuthority('can_write')")
    public String a() {
        return "A";
    }
    
    @GetMapping("/b")
    @PreAuthorize("hasAnyAuthority('can_write') || hasAnyAuthority('can_read')")
    public String b() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return "B";
    }
    
    @GetMapping("/c")
    public String c() {
        return "C";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

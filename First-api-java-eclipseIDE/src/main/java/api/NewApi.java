package api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class NewApi {

       @GetMapping("/test")

       public String testAPI() {
             return "success";
   }
}
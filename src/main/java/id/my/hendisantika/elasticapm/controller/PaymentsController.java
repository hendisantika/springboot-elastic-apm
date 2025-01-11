package id.my.hendisantika.elasticapm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-elastic-apm
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/01/25
 * Time: 06.36
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
public class PaymentsController {
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PostMapping(value = "/payments/json")
    public Map<String, Object> json(@RequestBody Map<String, Object> body) {
        log.info("body = {}", body);
        return new HashMap<>(1) {{
            put("id", UUID.randomUUID().toString());
        }};
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/payments/form", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    public void form(@RequestBody MultiValueMap<String, Object> body) {
        log.info("body = {}", body);
    }
}

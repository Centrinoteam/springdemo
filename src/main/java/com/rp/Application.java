package com.rp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.ErrorType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rongpei
 * @create 2017/10/10
 **/
@SpringBootApplication
@RestController
public class Application {
    @RequestMapping("/")
    public String greeting() {
        return "Hello World!";
    }

    @RequestMapping( value = {"/hello"} ,method =RequestMethod.POST )
    public String hello(@RequestBody TagsRequest tagsRequest) {

        return "Hello World111111111111!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

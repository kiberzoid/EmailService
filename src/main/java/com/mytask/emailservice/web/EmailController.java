package com.mytask.emailservice.web;

import com.mytask.emailservice.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    public static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendMessage(@Valid @RequestBody Message msg){
        LOG.info(msg.toString() + " was sent");
    }
}

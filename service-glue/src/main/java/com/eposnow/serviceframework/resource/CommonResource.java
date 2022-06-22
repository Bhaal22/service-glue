package com.eposnow.serviceframework.resource;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Tag(name = "apis")
@RestController
@RequestMapping("/")
public class CommonResource {

    public static final Logger logger = LoggerFactory.getLogger(CommonResource.class);

    @GetMapping("index*")
    public ModelAndView redirectToSwagger(ModelMap model){
        return new ModelAndView("redirect:/swagger-ui.html", model);
    }

    @GetMapping("")
    public ModelAndView index(ModelMap model){
        return redirectToSwagger(model);
    }

    @GetMapping("ping")
    public ResponseEntity<String> ping(){
        logger.info("/ping");
        return ResponseEntity.ok().body("pong");
    }

    @GetMapping("health")
    public ResponseEntity<String> health(){
        logger.info("/health");
        return ResponseEntity.ok().body("The service is healthy");
    }

}

package com.codigo.smartstore.webapi.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
 
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
 
    @RequestMapping("/")
    public String index() {
        logger.trace("a trace message logging");
        logger.debug("a debug message logging");
        logger.info("an info message logging");
        logger.warn("a warn message logging");
        logger.error("an error message logging");
 
        return "Witaj! zaraz wystartuje twoja aplikacja E_PENSUM";
    }
}

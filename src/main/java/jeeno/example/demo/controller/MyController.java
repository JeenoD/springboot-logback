package jeeno.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeeno
 * @version 0.0.1
 * @date 2019/9/3 22:15
 */
@RestController
@RequestMapping("/my")
public class MyController {

    /**
     * 自定义的log
     */
    private Logger log = LoggerFactory.getLogger("MYLOG");

    @GetMapping("/log")
    public void printLog(){
        log.info("here is the info.");
        log.error("here is the error.");
    }

}

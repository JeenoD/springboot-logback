package jeeno.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jeeno
 * @version: 0.0.1
 * @since: 2019/7/12 14:21
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

    @GetMapping("/info")
    public String infoLog(){
        log.info("添加一条info日志信息");
        return "info-log added.";
    }

    @GetMapping("/err")
    public String errorLog(){
        log.error("添加一条err日志信息");
        return "error-log added.";
    }
}

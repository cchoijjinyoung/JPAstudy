package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j // 아래 Logger log = LoggerFactory.getLogger(getClass()); 를 대신한다.
@Controller
public class HomeController {

    // Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String home() {
        log.info("home Controller");
        return "home";
    }
}

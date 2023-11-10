package kr.ac.kopo.dashboard.controller;

import kr.ac.kopo.dashboard.service.CommonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.engine.AttributeName;

import javax.xml.stream.events.Attribute;
import java.util.List;
import java.util.Map;

@Controller
public class CommonController {
    private final CommonService commonService;
    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Map<String, Object> map = commonService.getInoutStatus();


        model.addAttribute("inoutStatus", map);

        return "index";
    }

}

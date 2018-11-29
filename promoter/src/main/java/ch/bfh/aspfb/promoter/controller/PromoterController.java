package ch.bfh.aspfb.promoter.controller;

import ch.bfh.aspfb.promoter.service.PromoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromoterController {

    @Autowired
    private PromoterService promoterService;

    @GetMapping(value = "/promoteFight")
    public String promoteFight() {
        String result = promoterService.promoteFight();
        return "The Promoter is proud to proclaim the following result of today's battle: " + result;
    }
}

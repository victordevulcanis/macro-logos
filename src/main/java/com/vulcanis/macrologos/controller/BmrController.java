package com.vulcanis.macrologos.controller;

import com.vulcanis.macrologos.domain.dto.BmrRequest;
import com.vulcanis.macrologos.domain.dto.BmrResponse;
import com.vulcanis.macrologos.domain.entity.User;
import com.vulcanis.macrologos.service.BmrCalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1/calculator")
public class BmrController {

    private final BmrCalculatorService bmrService;

    public BmrController(BmrCalculatorService bmrService) {
        this.bmrService = bmrService;
    }

    @PostMapping
    public ResponseEntity<BmrResponse> calculate(@RequestBody BmrRequest request) {

        User user = new User();
        user.setWeight(request.weight());
        user.setHeight(request.height());
        user.setBirthDate(request.birthDate());
        user.setBiologicalSex(request.biologicalSex());
        user.setActivityLevel(request.activityLevel());

        double bmr = bmrService.calculateBmr(user);
        double tdee = bmrService.calculateTdee(user);

        BmrResponse response = new BmrResponse(bmr, tdee);

        return ResponseEntity.ok(response);
    }
}
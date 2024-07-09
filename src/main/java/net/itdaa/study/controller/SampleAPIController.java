package net.itdaa.study.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Api(tags = {"Rest API 개발을 위한 Sample Controller"})
@RestController
@RequestMapping("/sample")
public class SampleAPIController {

    @Operation(summary = "아주 간단한 RestAPI 요청", description = "입력한 글자를 reverse 하여 반환")
    @GetMapping("/get/example-simple-api")
    public ResponseEntity<Map<String,Object>> getExampleSimpleApi(
            @Parameter(description = "입력하는 문자(열)", required = true, example = "Input String.")
            @RequestParam String inputParam) {

        Map<String,Object> retMap = new HashMap<>();

        log.debug("Parameter Input Value : [{}]",inputParam);

        retMap.put("you-input-data",inputParam);
        retMap.put("reverse-input-data",new StringBuilder(inputParam).reverse().toString());

        return ResponseEntity.ok().body(retMap);
    }
}

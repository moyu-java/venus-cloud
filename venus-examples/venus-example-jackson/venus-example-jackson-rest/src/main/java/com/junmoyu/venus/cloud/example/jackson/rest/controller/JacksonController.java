package com.junmoyu.venus.cloud.example.jackson.rest.controller;

import com.junmoyu.venus.cloud.example.jackson.rest.model.RestDTO;
import com.junmoyu.venus.cloud.starter.core.model.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author moyu.jun
 * @date 2021/12/25
 */
@Slf4j
@RestController
@RequestMapping("jackson")
public class JacksonController {

    @GetMapping("/params")
    public Response<RestDTO> test1(RestDTO query) {
        log.info(query.toString());
        return Response.success(getRestDTO());
    }

    @GetMapping("/body")
    public Response<RestDTO> test2(@RequestBody RestDTO query) {
        log.info(query.toString());
        return Response.success(getRestDTO());
    }

    @GetMapping("/request/param")
    public Response<RestDTO> getDate(@RequestParam LocalDate date, @RequestParam LocalDateTime dateTime, @RequestParam Date originalDate) {
        log.info(date.toString());
        log.info(dateTime.toString());
        log.info(originalDate.toString());
        return Response.success(getRestDTO());
    }

    private RestDTO getRestDTO() {
        return RestDTO.builder()
                .strParam("string param.")
                .intParam(99)
                .longParam(1222233333333333333L)
                .booleanParam(true)
                .bigIntegerParam(new BigInteger("1222233333333333333"))
                .bigDecimalParam(new BigDecimal("0.000001"))
                .localDate(LocalDate.now())
                .localTime(LocalTime.now())
                .localDateTime(LocalDateTime.now())
                .date(new Date())
                .build();
    }
}

package com.junmoyu.venus.cloud.example.jackson.feign;

import com.junmoyu.venus.cloud.example.jackson.api.RemoteRestService;
import com.junmoyu.venus.cloud.example.jackson.api.RestDTO;
import com.junmoyu.venus.cloud.starter.core.model.dto.Response;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("feign")
@RequiredArgsConstructor
public class FeignController {

    private final RemoteRestService remoteRestService;

    @GetMapping("/params")
    public Response<RestDTO> test1(RestDTO query) {
        log.info(query.toString());
        return remoteRestService.test1(query);
    }

    @GetMapping("/body")
    public Response<RestDTO> test2(@RequestBody RestDTO query) {
        log.info(query.toString());
        return remoteRestService.test2(query);
    }

    @GetMapping("/request/param")
    public Response<RestDTO> getDate(@RequestParam LocalDate date, @RequestParam LocalDateTime dateTime, @RequestParam Date originalDate) {
        log.info(date.toString());
        log.info(dateTime.toString());
        log.info(originalDate.toString());
        return remoteRestService.getDate(date, dateTime, originalDate);
    }
}

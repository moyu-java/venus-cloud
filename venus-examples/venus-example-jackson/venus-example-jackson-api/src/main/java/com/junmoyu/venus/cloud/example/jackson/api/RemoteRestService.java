package com.junmoyu.venus.cloud.example.jackson.api;

import com.junmoyu.venus.cloud.starter.core.model.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author moyu.jun
 * @date 2021/12/25
 */
@FeignClient(name = "test", url = "http://localhost:8080")
public interface RemoteRestService {
    @GetMapping("/jackson/params")
    Response<RestDTO> test1(@SpringQueryMap RestDTO query);

    @GetMapping("/jackson/body")
    Response<RestDTO> test2(@RequestBody RestDTO query);

    @GetMapping("/jackson/request/param")
    Response<RestDTO> getDate(@RequestParam("date") LocalDate date, @RequestParam("dateTime") LocalDateTime dateTime,
                              @RequestParam("dateTime") Date originalDate);
}

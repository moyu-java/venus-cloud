package com.junmoyu.venus.cloud.example.jackson.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String strParam;
    private Integer intParam;
    private Boolean booleanParam;
    private Long longParam;
    private BigInteger bigIntegerParam;
    private BigDecimal bigDecimalParam;
//    private LocalDate localDate;
//    private LocalDateTime localDateTime;
//    private LocalTime localTime;
    private Date date;
}

package com.junmoyu.venus.cloud.example.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author moyu.jun
 * @date 2021/12/18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 9017938159224510504L;

    private String username;

    private Integer age;

    private Long birthday;
}

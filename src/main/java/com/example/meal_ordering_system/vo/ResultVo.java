package com.example.meal_ordering_system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {
    Integer code;
    String message;
    Boolean success;
    Object data;
    Object UserInfo;
    Object  Notice;
    Integer total;
}

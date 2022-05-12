package com.example.vo;

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

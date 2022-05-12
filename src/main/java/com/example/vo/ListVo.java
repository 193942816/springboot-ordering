package com.example.vo;

import lombok.Data;

import java.util.List;

@Data
public class ListVo<T> {
    private List<T> list;
    private Integer total;
}

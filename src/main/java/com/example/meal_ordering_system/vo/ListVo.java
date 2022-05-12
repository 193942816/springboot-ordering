package com.example.meal_ordering_system.vo;

import lombok.Data;

import java.util.List;

@Data
public class ListVo<T> {
    private List<T> list;
    private Integer total;
}

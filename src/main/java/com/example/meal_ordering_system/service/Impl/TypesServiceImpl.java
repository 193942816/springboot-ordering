package com.example.meal_ordering_system.service.Impl;

import com.example.meal_ordering_system.dao.TypesMapper;
import com.example.meal_ordering_system.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesMapper typesMapper;
}

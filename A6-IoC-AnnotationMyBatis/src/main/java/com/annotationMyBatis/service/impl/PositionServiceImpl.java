package com.annotationMyBatis.service.impl;

import com.annotationMyBatis.mapper.PositionMapper;
import com.annotationMyBatis.pojo.Position;
import com.annotationMyBatis.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionMapper positionMapper;
    @Autowired
    public PositionServiceImpl(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    @Override
    public void list() {
        List<Position> positions = positionMapper.selectList();
        positions.forEach(System.out::println);
    }
}

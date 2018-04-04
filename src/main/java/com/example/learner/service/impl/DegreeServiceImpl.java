package com.example.learner.service.impl;

import com.example.learner.bean.Degree;
import com.example.learner.mapper.DegreeMapper;
import com.example.learner.service.IDegreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
@Service
public class DegreeServiceImpl implements IDegreeService {

    @Resource
    private DegreeMapper degreeMapper;

    @Override
    public List<Degree> findAll() {
        return degreeMapper.findAll();
    }

    @Override
    public void add(String degree) {
        degreeMapper.add(degree);
    }

    @Override
    public void update(Degree degree) {
        degreeMapper.update(degree);
    }

    @Override
    public void delete(Integer id) {
        degreeMapper.delete(id);
    }
}

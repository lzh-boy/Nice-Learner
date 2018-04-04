package com.example.learner.service.impl;

import com.example.learner.bean.Category;
import com.example.learner.bean.Hobby;
import com.example.learner.mapper.HobbyMapper;
import com.example.learner.service.IHobbyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
@Service
public class HobbyServiceImpl implements IHobbyService {

    @Resource
    private HobbyMapper hobbyMapper;

    @Override
    public List<Category> findCategorysByUserId(Integer userId) {
        return hobbyMapper.findCategorysByUserId(userId);
    }

    @Override
    public void addBatchCategory(List<Hobby> listHobby) {
        hobbyMapper.addBatchCategory(listHobby);
    }
}

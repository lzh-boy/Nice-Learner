package com.example.learner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.learner.bean.Aspect;
import com.example.learner.mapper.AspectMapper;
import com.example.learner.service.IAspectService;

/**
 * 业务层
 * @author xyl
 *
 */
@Service
public class AspectServiceImpl implements IAspectService {

	@Resource
	private AspectMapper aspectMapper;
	
	@Override
	public List<Aspect> findAll() {
		return aspectMapper.findAll();
	}

	@Override
	public void add(Aspect aspect) {
        aspectMapper.add(aspect);
	}

	@Override
	public void update(Aspect aspect) {
		aspectMapper.update(aspect);
	}

	@Override
	public void delete(Integer id) {
		aspectMapper.delete(id);
	}
	

}

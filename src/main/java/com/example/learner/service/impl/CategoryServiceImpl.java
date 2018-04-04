package com.example.learner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.learner.bean.Category;
import com.example.learner.mapper.CategoryMapper;
import com.example.learner.service.ICategoryService;

/**
 * 业务层
 * @author xyl
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findAll() {
		return categoryMapper.findAll();
	}

	@Override
	public List<Category> findCateforysByAspectId(Integer aspectId) {
		return categoryMapper.findCateforysByAspectId(aspectId);
	}

	@Override
	public void add(Category category) {
		categoryMapper.add(category);
	}

	@Override
	public void update(Category category) {
		categoryMapper.update(category);
	}

	@Override
	public void delete(Integer id) {
		categoryMapper.delete(id);
	}
	

}

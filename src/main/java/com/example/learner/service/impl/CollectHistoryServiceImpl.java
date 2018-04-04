package com.example.learner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.learner.bean.CollectHistory;
import com.example.learner.mapper.CollectHistoryMapper;
import com.example.learner.service.ICollectHistoryService;

/**
 * 业务层
 * @author xyl
 *
 */
@Service
public class CollectHistoryServiceImpl implements ICollectHistoryService {

	@Resource
	private CollectHistoryMapper collectHistoryMapper;
	
	@Override
	public CollectHistory findCollectHistoryById(Integer id) {
		return collectHistoryMapper.findCollectHistoryById(id);
	}

	@Override
	public List<CollectHistory> findAll() {
		return collectHistoryMapper.findAll();
	}

	@Override
	public void add(CollectHistory collectHistory) {
		collectHistoryMapper.add(collectHistory);
	}

	@Override
	public void update(CollectHistory collectHistory) {
		collectHistoryMapper.update(collectHistory);
	}

	@Override
	public void delete(Integer id) {
		collectHistoryMapper.delete(id);
	}

}

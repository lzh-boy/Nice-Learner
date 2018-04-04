package com.example.learner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.example.learner.bean.Reply;
import org.springframework.stereotype.Service;

import com.example.learner.mapper.ReplyMapper;
import com.example.learner.service.IReplyService;

/**
 * 业务层
 * @author xyl
 *
 */
@Service
public class ReplyServiceImpl implements IReplyService {

	@Resource
	private ReplyMapper replyMapper;
	@Override
	public Reply findReplyById(Integer id) {
		return replyMapper.findReplyById(id);
	}

	@Override
	public List<Reply> findAll() {
		return replyMapper.findAll();
	}

	@Override
	public void add(Reply reply) {
		replyMapper.add(reply);
	}

	@Override
	public void update(Reply reply) {
		replyMapper.update(reply);
	}

	@Override
	public void delete(Integer id) {
		replyMapper.delete(id);
	}

}

package com.example.learner.service;

import com.example.learner.bean.Reply;

import java.util.List;

/**
 * 回复业务逻辑接口
 * @author xyl
 *
 */
public interface IReplyService {

	/**
     * 通过id查找回复
     * @param id
     * @return
     */
    Reply findReplyById(Integer id);

    /**
     * 查找全部回复
     * @return
     */
    List<Reply> findAll();

    /**
     * 添加一位回复
     * @param reply
     */
    void add(Reply reply);

    /**
     * 更新一位回复
     * @param reply
     */
    void update(Reply reply);

    /**
     * 删除一位回复
     * @param id
     */
    void delete(Integer id);
}

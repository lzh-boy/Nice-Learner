package com.example.learner.service;

import java.util.List;

import com.example.learner.bean.CollectHistory;

/**
 * 收藏或历史记录业务逻辑接口
 * @author xyl
 *
 */
public interface ICollectHistoryService {

	/**
     * 通过id查找收藏或历史记录
     * @param id
     * @return
     */
    CollectHistory findCollectHistoryById(Integer id);

    /**
     * 查找全部角色
     * @return
     */
    List<CollectHistory> findAll();

    /**
     * 添加一位角色
     * @param collectHistory
     */
    void add(CollectHistory collectHistory);

    /**
     * 更新一位角色
     * @param collectHistory
     */
    void update(CollectHistory collectHistory);

    /**
     * 删除一位角色
     * @param id
     */
    void delete(Integer id);
}

package com.example.learner.service;

import java.util.List;



import com.example.learner.bean.Aspect;

/**
 * 课程方向业务逻辑接口
 * @author xyl
 *
 */
public interface IAspectService {

	/**
     * 查找所有方向
     * @return
     */
    List<Aspect> findAll();

    /**
     * 添加一个方向
     * @param aspect
     */
    void add(String aspect);

    /**
     * 更新一个方向
     * @param aspect
     */
    void update(Aspect aspect);

    /**
     * 删除一个方向
     * @param id
     */
    void delete(Integer id);
}

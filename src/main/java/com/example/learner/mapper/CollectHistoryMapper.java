package com.example.learner.mapper;

import com.example.learner.bean.CollectHistory;
import com.example.learner.bean.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/3/31
 */
@Mapper
@Component
public interface CollectHistoryMapper {

    /**
     * 通过id查找收藏或历史记录
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_collect_history WHERE id = #{id}")
    CollectHistory findCollectHistoryById(Integer id);

    /**
     * 查找全部角色
     * @return
     */
    @Select("SELECT * FROM tb_collect_history")
    List<CollectHistory> findAll();

    /**
     * 添加一位角色
     * @param collectHistory
     */
    @Insert(" INSERT INTO tb_collect_history(courseId,lastTime,userId,ishistory,iscollect) VALUES (#{courseId},#{lastTime},#{userId},#{ishistory},#{iscollect})")
    void add(CollectHistory collectHistory);

    /**
     * 更新一位角色
     * @param collectHistory
     */
    @Update("update tb_collect_history set courseId = #{courseId},lastTime = #{lastTime},userId = #{userId},ishistory = #{ishistory},iscollect = #{iscollect} where id = #{id} ")
    void update(CollectHistory collectHistory);

    /**
     * 删除一位角色
     * @param id
     */
    @Delete("DELETE FROM tb_collect_history WHERE id = #{id}")
    void delete(Integer id);

}

package com.example.learner.service;

import com.example.learner.bean.Notes;

import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
public interface INotesService {

    /**
     * 查找所有
     */
    List<Notes> findAll();

    /**
     *通过Id查找笔记
     */
    Notes findNotesById(Integer id);

    /**
     * 通过UserId查找笔记
     * @param id
     * @return
     */
    List<Notes> findNotesByUserId(Integer id);

    /**
     * 通过createDate查找笔记
     */
    List<Notes> findNotesByCreateDate(String createTime);

    /**
     * 添加笔记
     * @param
     */
    void add(Notes notes);

    /**
     * 根据id更新笔记
     * @param
     */
    void update(Notes notes);

    /**
     * 通过Id删除笔记
     * @param id
     */

    void delete(Integer id);
}

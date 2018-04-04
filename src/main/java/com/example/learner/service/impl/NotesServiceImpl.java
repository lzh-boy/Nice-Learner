package com.example.learner.service.impl;

import com.example.learner.bean.Notes;
import com.example.learner.mapper.NotesMapper;
import com.example.learner.service.INotesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/2
 */
@Service
public class NotesServiceImpl implements INotesService {

    @Resource
    private NotesMapper notesMapper;

    @Override
    public List<Notes> findAll() {
        return null;
    }

    @Override
    public Notes findNotesById(Integer id) {
        return null;
    }

    @Override
    public List<Notes> findNotesByUserId(Integer id) {
        return null;
    }

    @Override
    public List<Notes> findNotesByCreateDate(String createTime) {
        return null;
    }

    @Override
    public void add(Notes notes) {

    }

    @Override
    public void update(Notes notes) {

    }

    @Override
    public void delete(Integer id) {

    }
}

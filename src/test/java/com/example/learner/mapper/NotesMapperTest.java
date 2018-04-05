package com.example.learner.mapper;

import com.example.learner.bean.Notes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * create by LTY
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesMapperTest {
    private Logger logger=LoggerFactory.getLogger(NotesMapperTest.class);

    @Resource
    private  NotesMapper notesMapper;

    @Test
    public void findAll(){
        List<Notes> list=notesMapper.findAll();
        for (Notes notes:list){
            logger.info(notes.getContent());
        }
    }

    @Test
    public void findNotesById(){
        Notes list=notesMapper.findNotesById(2);
        logger.info(list.getContent());
    }

    @Test
    public void findNotesByUserId(){
        List<Notes> list2=notesMapper.findNotesByUserId(1);
        for (Notes notes:list2){
            logger.info(notes.getCreateDate());
        }
    }

    @Test
    public void findNoteByCreateDate(){
        List<Notes> list=notesMapper.findNotesByCreateDate("2018-04-03 11:25:17");
        for (Notes notes:list){
            logger.info(notes.getContent());
        }
    }

    @Test
    public void add(){
        Notes notes=new Notes(6,"LTY","2017-04-03 11:25:17");
        notesMapper.add(notes);
    }

    @Test
    public void delete(){
        notesMapper.delete(1);
    }

    @Test
    public void update(){
        notesMapper.update(
                new Notes(1,"testUpdate","2017-04-03 11:25:17"));
    }

}

package com.example.learner.mapper;

import com.example.learner.bean.Aspect;
import com.example.learner.bean.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiQian_Nice on 2018/4/1
 *
 * 方向数据库操作测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {

    private Logger logger= LoggerFactory.getLogger(CommentMapperTest.class);


    @Resource
    private CommentMapper commentMapper;

    @Test
    public void findAll(){
        List<Comment> list=commentMapper.findAll();
        for (Comment comment:list){
            logger.info(comment.getContent());
        }
    }

    @Test
    public void add(){
        Comment comment=new Comment(4,2,"2018-04-25 21:06:14"
                ,6,"测试44","3");
        commentMapper.add(comment);
    }

    @Test
    public void update(){
        commentMapper.update(new Comment(1,1,"2018-04-25 21:06:14"
                ,4,"测试1","2"));
    }

    @Test
    public void delete(){
        commentMapper.delete(4);
    }

}

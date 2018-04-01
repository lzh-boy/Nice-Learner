package com.example.learner.mapper;

import com.example.learner.bean.Role;
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
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    private Logger logger= LoggerFactory.getLogger(RoleMapperTest.class);

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void findRolesById(){
        logger.info(roleMapper.findRolesById(1).getRole());
    }
    @Test
    public void findAll(){
        List<Role> list=roleMapper.findAll();
        for (Role role:list){
            logger.info(role.getRole());
        }
    }
    @Test
    public void add(){
        roleMapper.add(new Role("test","测试",false));
    }

    @Test
    public void update(){
        roleMapper.update(new Role(5,"testUpdate","测试更新",false));
    }
    @Test
    public void delete(){

        roleMapper.delete(5);
    }
}

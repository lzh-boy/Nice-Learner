package com.example.learner;

import com.example.learner.bean.Role;
import com.example.learner.bean.User;
import com.example.learner.service.IRoleService;
import com.example.learner.service.IUserService;
import com.example.learner.util.LqNiceUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnerApplicationTests {

	@Resource
	private IUserService userService;

	@Resource
	private IRoleService roleService;

	@Test
	public void registerUser() {
		for (int i = 0; i < 17; i++) {
			User user = new User();
			user.setAccount("12345" + i);
			user.setName("123456" + i);
			user.setEmail("51103942@qq.com");
			user.setPlainPassword("12345678");
			user.setRoleId( 2);
			user.setCreateTime(LqNiceUtil.getCurrentDateTime());
			LqNiceUtil.entryptPassword(user);
			System.out.println(user);
			userService.add(user);
		}
	}

	@Test
	public void findAllUsers(){
		List<User> list=userService.findAll();
		for (User user:list){
			System.out.println(user.getId());
		}
	}

	@Test
	public void findUserByName(){
		User user=userService.findByName("1234560");
		System.out.println(user.getName());
		Role role=  roleService.findRolesById(user.getRoleId());
		System.out.println(role.getRole());
	}

	@Test
	public void findAllRoles(){
		List<Role> list=roleService.findAll();
		for (Role role:list){
			System.out.println(role.getRole());
		}
	}

	@Test
	public void addRole(){
		Role role=new Role();
		role.setRole("test");
		role.setDescription("test");
		role.setState(false);
		roleService.add(role);
	}

	@Test
	public void deleteRole(){
		roleService.delete( 5);
	}

	@Test
	public void findRoleByRid(){
		Role role=userService.findRoleByRid(2);
		System.out.println(role.getRole()+role.getDescription()+role.getId()+role.getState());

	}

	@Test
	public void findUsersByRid(){
		List<User> list=userService.findUsersByRid(2);
		for (User user:list){
			System.out.println(user.getId());
		}
	}
}

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
			user.setUserName("123456" + i);
			user.setEmail("51103942@qq.com");
			user.setIphone(12349857777L - i + "");
			user.setPlainPassword("12345678");
			user.setPlatform("qq");
			user.setRid((long) 2);
			user.setCreatedDate(LqNiceUtil.getCurrentDateTime());
			user.setUpdatedDate(LqNiceUtil.getCurrentDateTime());
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
		System.out.println(user.getAccount());
		Role role=  roleService.findRolesById(user.getRid());
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
		role.setAvailable(false);
		roleService.add(role);
	}

	@Test
	public void deleteRole(){
		roleService.delete((long) 5);
	}
}

package com.kshrd.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kshrd.model.Role;
import com.kshrd.model.User;

@Repository
public interface MybatisUserRepository {

	@Select("select id, username, password, gender, image from tbuser where username=#{username}")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "roles", column = "id", many = @Many(select = "findRolesByUserId"))
	})
	public User findUserByUsername(String username);
	
	@Select("select r.id, r.role from tbrole r "
			+ "inner join tbuser_role ur on r.id=ur.role_id where ur.user_id=#{id}")
	public List<Role> findRolesByUserId(int id);
	
}

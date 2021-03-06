package com.crm.service.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.User;
import com.crm.mapper.UserMapper;
import com.crm.service.IUserService;
import com.crm.util.UserContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public DataGrideResult pageList(Integer page, Integer rows, User user) {
		//1.设置分页
		PageHelper.startPage(page, rows);
		
		List<User> list = 	userMapper.pageList(user);
		//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
		PageInfo pageInfo = new PageInfo<>(list);
		Integer total = (int)pageInfo.getTotal();
		return new DataGrideResult<>(total, list);
	}

	@Override
	public ServerResponse delete(String ids) {
		String[] idsArray = ids.split(",");
		int count = userMapper.deleteAll(idsArray);
		if (count == idsArray.length) {
			return ServerResponse.createSuccess("删除成功");
		}
		return ServerResponse.createError("删除失败");
	}

	@Override
	public ServerResponse insert(User user) {
		int insert = userMapper.insert(user);
		if (insert>0) {
			return ServerResponse.createSuccess("添加成功");
		}
		return ServerResponse.createError("添加失败");
	}

	@Override
	public ServerResponse update(User user) {
		int count = userMapper.updateByPrimaryKey(user);
		if (count>0) {
			return ServerResponse.createSuccess("修改成功");
		}
		return ServerResponse.createError("修改失败");
	}

	@Override
	public List<User> findCustomerName() {
		return userMapper.findUserName();
	}

	@Override
	public ServerResponse selectByName(String name, String password,HttpServletRequest request) {
		UserContext.session = request.getSession();
		User user = userMapper.findUserByName(name,password);
		
		if (user != null) {
			// 把当前用户放到session中
            request.getSession().setAttribute(UserContext.USER_IN_SESSION, user);
			return ServerResponse.createSuccess("查找成功");
		}
		return ServerResponse.createError("查找失败");
	}

}

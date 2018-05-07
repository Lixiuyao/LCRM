package com.crm.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.crm.common.DataGrideResult;
import com.crm.common.ServerResponse;
import com.crm.entity.Permission;
import com.crm.mapper.PermissionMapper;
import com.crm.service.IPermissionService;
@Service
public class PermissionServiceImpl implements IPermissionService{
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public DataGrideResult<Permission> pageList(Integer page, Integer rows, Permission Permission) {
		//1.设置分页
		PageHelper.startPage(page, rows);
		//2.执行查询(查询的是分页之后的数据)
		List<Permission> list = permissionMapper.pageList(Permission);
		//3.得到满足条件的所有数据的数量，而上面的list是满足这个条件的某一页的数据
		PageInfo pageInfo = new PageInfo<>(list);
		Integer total = (int) pageInfo.getTotal();
		return new DataGrideResult<>(total, list);
	}

	@Override
	public ServerResponse delete(String ids) {
		String[] idsArray = ids.split(",");//[1,2,3]
		/*for (String id : idsArray) {
			PermissionMapper.deleteByPrimaryKey(Integer.parseInt(id));
		}
		return ServerResponse.createSUCCESS("删除成功");*/
		
		// delete from Permission where id in (1,2,3);
		int count = permissionMapper.deleteAll(idsArray);
		if (count == idsArray.length) {
			return ServerResponse.createSuccess("删除成功");
		}
		return ServerResponse.createError("删除失败");
	}

	@Override
	public ServerResponse add(Permission Permission) {
		int count = permissionMapper.insert(Permission);
		if (count > 0) {
			return ServerResponse.createSuccess("添加成功");
		}
		return ServerResponse.createError("添加失败");
	}
	
	@Override
	public ServerResponse update(Permission Permission) {
		int count = permissionMapper.updateByPrimaryKey(Permission);
		if (count > 0) {
			return ServerResponse.createSuccess("更新成功");
		}
		return ServerResponse.createError("更新失败");
	}

	@Override
	public DataGrideResult selectByRoleId(Integer roleId) {
		List<Permission> list = permissionMapper.selectByRoleId(roleId);
		return new DataGrideResult<>(list.size(), list);
	}
}

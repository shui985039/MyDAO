package cn.mldn.service;

import java.util.List;
import java.util.Set;

import cn.mldn.vo.Dept;

public interface IDeptService {
	/**
	 * 增加操作需要首先利用IDeptDAO.findById()判断，而后使用IDeptDAO.doCreate()保存
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Dept vo) throws Exception ;
	public boolean update(Dept vo) throws Exception ;
	public boolean delete(Set<Integer> ids) throws Exception ;
	public Dept get(Integer id) throws Exception ;
	public List<Dept> list() throws Exception ; 
}

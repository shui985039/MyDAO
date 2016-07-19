package cn.mldn.service;

import java.util.List;
import java.util.Set;

import cn.mldn.vo.Dept;

public interface IDeptService {
	/**
	 * ���Ӳ�����Ҫ��������IDeptDAO.findById()�жϣ�����ʹ��IDeptDAO.doCreate()����
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

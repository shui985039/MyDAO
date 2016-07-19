package cn.mldn.dao;

import java.util.List;

import cn.mldn.vo.Emp;

public interface IEmpDAO extends IDAO<Integer, Emp> {
	/**
	 * ���ö���ѯ����ѯ��ϸ����Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Emp findByIdDetails(Integer id) throws Exception ;
	public List<Emp> findAllDetails() throws Exception ;
}

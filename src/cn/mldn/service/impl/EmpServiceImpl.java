package cn.mldn.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dbc.DatabaseConnection;
import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IEmpService;
import cn.mldn.vo.Emp; 

/**
 * ��ȡ���˱������ʱ������ζ�ſ��Խ������ݿ�����ˡ�
 * 
 * @author mldn
 */
public class EmpServiceImpl implements IEmpService {
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean insert(Emp vo) throws Exception {
		try {
			// ����DAOFactory���е�getIEmpDAOInstance()����ȡ��IEmpDAO�ӿڶ���
			// �ڵ���getIEmpDAOInstance()ʱ����Ҫͨ��DatabaseConnection����ȡ��Connection�ӿڶ��󣬴��ݽ�ȥ
			// ����IEmpDAO�ӿ��е�findById()�����ж�Ҫ�������ݵĹ�Ա����Ƿ����
			if (DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findById(vo.getEmpno()) == null) {
				return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doCreate(vo) ;
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Emp vo) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean delete(Set<Integer> ids) throws Exception {
		try {
			if (ids.size() == 0) {	// û��Ҫɾ��������
				return false ;
			}
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).doRemove(ids);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Emp get(int id) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Emp> list() throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Map<String, Object> listSplit(String column, String keyWord, int currentPage, int lineSize)
			throws Exception {
		try {
			Map<String,Object> map = new HashMap<String,Object>() ;
			map.put("allEmps", DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findAllSplit(column, keyWord, currentPage, lineSize)) ;
			map.put("empCount", DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).getAllCount(column, keyWord)) ;
			return map ;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public Emp getDetails(int id) throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findByIdDetails(id) ;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public List<Emp> listDetails() throws Exception {
		try {
			return DAOFactory.getIEmpDAOInstance(this.dbc.getConnection()).findAllDetails() ;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

}

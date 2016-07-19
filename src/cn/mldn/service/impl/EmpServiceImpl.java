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
 * 当取得了本类对象时，就意味着可以进行数据库操作了。
 * 
 * @author mldn
 */
public class EmpServiceImpl implements IEmpService {
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean insert(Emp vo) throws Exception {
		try {
			// 利用DAOFactory类中的getIEmpDAOInstance()方法取得IEmpDAO接口对象
			// 在调用getIEmpDAOInstance()时候需要通过DatabaseConnection对象取得Connection接口对象，传递进去
			// 调用IEmpDAO接口中的findById()方法判断要增加数据的雇员编号是否存在
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
			if (ids.size() == 0) {	// 没有要删除的数据
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

package cn.mldn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IEmpDAO;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;
/**
 * 如果要想操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * @author mldn
 */
public class EmpDAOImpl implements IEmpDAO {
	private Connection conn ;	// 数据库连接对象
	private PreparedStatement pstmt ; 	// 数据库的操作对象
	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public EmpDAOImpl(Connection conn) {
		this.conn = conn ;
	}
	@Override
	public boolean doCreate(Emp vo) throws Exception {
		String sql = "INSERT INTO emp(empno,ename,job,hiredate,sal,comm,mgr,deptno) VALUES (?,?,?,?,?,?,?,?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, vo.getEmpno());
		this.pstmt.setString(2, vo.getEname());
		this.pstmt.setString(3, vo.getJob());
		this.pstmt.setDate(4, new java.sql.Date(vo.getHiredate().getTime()));
		this.pstmt.setDouble(5, vo.getSal()); 
		this.pstmt.setDouble(6, vo.getComm()); 
		if (vo.getMgr() != null) {	// 有领导信息
			this.pstmt.setInt(7, vo.getMgr().getEmpno());
		} else {
			// this.pstmt.setString(7, null);
			this.pstmt.setNull(7, Types.NULL);
		}
		if (vo.getDept() != null) {
			this.pstmt.setInt(8, vo.getDept().getDeptno());
		} else {
			this.pstmt.setNull(8, Types.NULL);
		}
		return this.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public boolean doUpdate(Emp vo) throws Exception {
		String sql = "UPDATE emp SET ename=?,job=?,hiredate=?,sal=?,comm=?,mgr=?,deptno=? WHERE empno=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, vo.getEname());
		this.pstmt.setString(2, vo.getJob());
		this.pstmt.setDate(3, new java.sql.Date(vo.getHiredate().getTime()));
		this.pstmt.setDouble(4, vo.getSal()); 
		this.pstmt.setDouble(5, vo.getComm());
		if (vo.getMgr() != null) {	// 有领导信息
			this.pstmt.setInt(6, vo.getMgr().getEmpno());
		} else {
			// this.pstmt.setString(7, null);
			this.pstmt.setNull(6, Types.NULL);
		}
		if (vo.getDept() != null) {
			this.pstmt.setInt(7, vo.getDept().getDeptno());
		} else {
			this.pstmt.setNull(7, Types.NULL);
		}
		this.pstmt.setInt(8, vo.getEmpno());
		return this.pstmt.executeUpdate() > 0 ;
	}

	@Override
	public boolean doRemove(Set<Integer> ids) throws Exception {
		StringBuffer sql = new StringBuffer() ;
		sql.append("DELETE FROM emp WHERE empno IN (") ;
		Iterator<Integer> iter = ids.iterator() ;
		while (iter.hasNext()) {
			sql.append(iter.next()).append(",") ;
		}
		sql.delete(sql.length() - 1, sql.length());	// 删除掉最后的“,”
		sql.append(")") ;
		this.pstmt = this.conn.prepareStatement(sql.toString()) ;
		return this.pstmt.executeUpdate() == ids.size();
	}

	@Override
	public Emp findById(Integer id) throws Exception {
		Emp vo = null ;
		String sql = "SELECT empno,ename,job,hiredate,sal,comm FROM emp WHERE empno=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Emp() ;
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
		}
		return vo;
	}

	@Override
	public List<Emp> findAll() throws Exception {
		List<Emp> all = new ArrayList<Emp>() ;
		String sql = "SELECT empno,ename,job,hiredate,sal,comm FROM emp" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Emp vo = new Emp() ;
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			all.add(vo) ;
		}
		return all ;
	}

	@Override
	public List<Emp> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
		List<Emp> all = new ArrayList<Emp>();
		String sql = "SELECT * FROM " + " ( SELECT empno,ename,job,hiredate,sal,comm,ROWNUM rn " + " FROM emp WHERE "
				+ column + " LIKE ? AND ROWNUM<=?) temp " + " WHERE temp.rn>? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setInt(2, currentPage * lineSize);
		this.pstmt.setInt(3, (currentPage - 1) * lineSize);
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Emp vo = new Emp() ;
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			all.add(vo) ;
		}
		return all ;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		String sql = "SELECT COUNT(*) FROM emp WHERE " + column + " LIKE ? " ;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			return rs.getInt(1) ;
		}
		return null; 
	}
	@Override
	public Emp findByIdDetails(Integer id) throws Exception {
		Emp vo = null ;
		String sql = "SELECT e.empno,e.ename,e.job,e.hiredate,e.sal,e.comm,m.empno mno,m.ename mname,d.deptno dno,d.dname dna,d.loc dl"
				+ " FROM emp e,emp m,dept d"
				+ " WHERE e.empno=? AND e.mgr=m.empno(+) AND e.deptno=d.deptno(+)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Emp() ;
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			Emp mgr = new Emp();
			mgr.setEmpno(rs.getInt(7));
			mgr.setEname(rs.getString(8));
			Dept dept = new Dept() ;
			dept.setDeptno(rs.getInt(9));
			dept.setDname(rs.getString(10));
			dept.setLoc(rs.getString(11));
			vo.setMgr(mgr);
			vo.setDept(dept);
		}
		return vo;
	}
	@Override
	public List<Emp> findAllDetails() throws Exception {
		List<Emp> all = new ArrayList<Emp>() ;
		String sql = "SELECT e.empno,e.ename,e.job,e.hiredate,e.sal,e.comm,m.empno mno,m.ename mname,d.deptno dno,d.dname dna,d.loc dl"
				+ " FROM emp e,emp m,dept d"
				+ " WHERE e.mgr=m.empno(+) AND e.deptno=d.deptno(+)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Emp vo = new Emp() ;
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			Emp mgr = new Emp();
			mgr.setEmpno(rs.getInt(7));
			mgr.setEname(rs.getString(8));
			Dept dept = new Dept() ;
			dept.setDeptno(rs.getInt(9));
			dept.setDname(rs.getString(10));
			dept.setLoc(rs.getString(11));
			vo.setMgr(mgr);
			vo.setDept(dept);
			all.add(vo) ;
		}
		return all ;
	}

}

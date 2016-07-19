package cn.mldn.test.main;

import java.util.Date;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Dept;
import cn.mldn.vo.Emp;

public class TestEmpInsert {
	public static void main(String[] args) throws Exception {
		Emp vo = new Emp();
		vo.setEmpno(1111);
		vo.setEname("Ê©¹¤");
		vo.setJob("±£½à");
		vo.setHiredate(new Date());
		vo.setSal(1.0);
		vo.setComm(100.0);
		Emp mgr = new Emp();
		mgr.setEmpno(7369);
		vo.setMgr(mgr);
		Dept dept = new Dept() ;
		dept.setDeptno(10);
		vo.setDept(dept);
		System.out.println(ServiceFactory.getIEmpServiceInstance().insert(vo));
	}
}

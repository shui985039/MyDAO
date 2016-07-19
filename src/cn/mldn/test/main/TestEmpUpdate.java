package cn.mldn.test.main;

import java.util.Date;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Emp;

public class TestEmpUpdate {
	public static void main(String[] args) throws Exception {
		Emp vo = new Emp();
		vo.setEmpno(9999);
		vo.setEname("ʩ��");
		vo.setJob("����");
		vo.setHiredate(new Date());
		vo.setSal(2.0);
		vo.setComm(101.0);
		System.out.println(ServiceFactory.getIEmpServiceInstance().update(vo)); 
	}
}

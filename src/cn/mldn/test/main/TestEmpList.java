package cn.mldn.test.main;

import java.util.Iterator;
import java.util.List;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Emp;

public class TestEmpList {
	public static void main(String[] args) throws Exception {
		List<Emp> allEmps = ServiceFactory.getIEmpServiceInstance().listDetails();
		Iterator<Emp> iter = allEmps.iterator();
		while (iter.hasNext()) {
			Emp e = iter.next();
			System.out.println(e.getEname() + "£¬" + e.getMgr().getEname() + "£¬" + e.getDept().getDname());
		}
	}
}

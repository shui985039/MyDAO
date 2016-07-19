package cn.mldn.test.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Emp;

public class TestEmpListSplit {
	public static void main(String[] args) throws Exception {
		Map<String, Object> map = ServiceFactory.getIEmpServiceInstance().listSplit("ename", "S", 1, 10);
		List<Emp> allEmps = (List<Emp>) map.get("allEmps") ;
		Integer empCount = (Integer) map.get("empCount") ;
		System.out.println("符合查询的数据量：" + empCount);
		Iterator<Emp> iter = allEmps.iterator() ;
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}

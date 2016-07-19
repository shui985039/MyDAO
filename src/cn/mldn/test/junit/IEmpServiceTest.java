package cn.mldn.test.junit;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Emp;
import junit.framework.TestCase;

public class IEmpServiceTest {
 
	@Test
	public void testInsert() {
		Emp vo = new Emp();
		vo.setEmpno(8888);
		vo.setEname("施工2");
		vo.setJob("保洁3");
		vo.setHiredate(new Date());
		vo.setSal(3.0);
		vo.setComm(130.0);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Emp vo = new Emp();
		vo.setEmpno(8888);
		vo.setEname("施工7");
		vo.setJob("保洁7");
		vo.setHiredate(new Date());
		vo.setSal(1.0);
		vo.setComm(110.0);
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Set<Integer> all = new HashSet<Integer>() ;
		all.add(8888) ;
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().delete(all));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIEmpServiceInstance().get(7369));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().list().size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListSplit() {
		try {
			Map<String, Object> map = ServiceFactory.getIEmpServiceInstance().listSplit("ename", "S", 1, 10);
			List<Emp> allEmps = (List<Emp>) map.get("allEmps") ;
			Integer empCount = (Integer) map.get("empCount") ;
			TestCase.assertTrue(allEmps.size() > 0 && empCount > 0 );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

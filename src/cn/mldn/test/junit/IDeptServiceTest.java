package cn.mldn.test.junit;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.vo.Dept;
import junit.framework.TestCase;

public class IDeptServiceTest {

	@Test
	public void testInsert() {
		Dept vo = new Dept() ;
		vo.setDeptno(90);
		vo.setDname("单身部");
		vo.setLoc("地狱");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		Dept vo = new Dept() ;
		vo.setDeptno(90);
		vo.setDname("冲昏部");
		vo.setLoc("恶心");
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		Set<Integer> ids = new HashSet<Integer>() ;
		ids.add(90) ;
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().delete(ids));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet() {
		try {
			TestCase.assertNotNull(ServiceFactory.getIDeptServiceInstance().get(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		try {
			TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().list().size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

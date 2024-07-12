package test;

import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import DAO.UserDAO;
import model.User;
import util.JPAUtils;

public class TestSignup {
	UserDAO udao = new UserDAO();
	static int count, index;
	@Rule
	public ErrorCollector ec = new ErrorCollector();

	@BeforeClass
	public static void OpenConnect() {

	}

	public int countUser() {
		int temp = 0;
		try {
			List<User> u = udao.findAll();
			temp = u.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Before
	public void beforeUser() {
		count = countUser();
		System.out.println(count);
	}

	@Test
	public void testSignup1() {
		try {
			User user = new User();
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup2() {
		try {
			User user = new User();
			user.setUsersID("");
			user.setPass("123456");
			user.setFullName("Vũ Trung Kiên");
			user.setEmail("vtk@fpt.edu.vn");
			user.setAdmin(false);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null user: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@Test
	public void testSignup3() {
		try {
			User user = new User();
			user.setUsersID("kienvt");
			user.setPass("");
			user.setFullName("Vũ Trung Kiên");
			user.setEmail("vtk@fpt.edu.vn");
			user.setAdmin(false);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null pass: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup4() {
		try {
			User user = new User();
			user.setUsersID("kienvt");
			user.setPass("123456");
			user.setFullName("");
			user.setEmail("vtk@fpt.edu.vn");
			user.setAdmin(false);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null FullName: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@Test
	public void testSignup5() {
		try {
			User user = new User();
			user.setUsersID("kienvt");
			user.setPass("123456");
			user.setFullName("Vũ Trung Kiên");
			user.setEmail("");
			user.setAdmin(false);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null Email: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@Test
	public void testSignup6() {
		try {
			User user = new User();
			user.setUsersID("");
			user.setPass("123456");
			user.setFullName("Vũ Trung Kiên");
			user.setEmail("vtk");
			user.setAdmin(false);;
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check sai định dạng Email: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@Test
	public void testSignup7() {
		try {
			User user = new User();
			user.setUsersID("kienvt");
			user.setPass("123456");
			user.setFullName("Vũ Trung Kiên");
			user.setEmail("vtk@fpt.edu.vn");
			user.setAdmin(true);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Check đầy đủ thông tin: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@After
	public void afterUser() {
		System.out.println(count);
	}

	@AfterClass
	public static void CloseConnect() {
		
	}

	
}

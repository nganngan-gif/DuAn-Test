package test;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import DAO.UserDAO;
import model.User;

public class TestUpdate {

	UserDAO udao = new UserDAO();

	@BeforeClass
	public static void OpenConnect() {

	}

	@Before
	public void beforeUser() {

	}

	@Test
	public void testUpdateNullusername() {
		boolean t ;
		User uip = new User();
		try {

			uip.setUsersID("");
			uip.setPass("123456");
			uip.setFullName("Vũ Trung Kien");
			uip.setEmail("vtk@fpt.edu.vn");
			uip.setAdmin(false);
			udao.update(uip);

		} catch (Exception e) {
			// TODO: handle exception
		}
		User ubf = udao.findById(uip.getUsersID());
		if (ubf != null) {
			boolean temp = uip.getUsersID().equals(ubf.getUsersID()) && uip.getPass().equals(ubf.getPass())
					&& uip.getFullName().equals(ubf.getFullName()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			
			t = temp;
		}else {
			t = false;
		}

		assertFalse(t);
	}
	
	@Test
	public void testUpdateNullpass() {
		boolean t ;
		User uip = new User();
		try {

			uip.setUsersID("kienvt");
			uip.setPass("");
			uip.setFullName("Vũ Trung Kien");
			uip.setEmail("vtk@fpt.edu.vn");
			uip.setAdmin(false);
			udao.update(uip);

		} catch (Exception e) {
			// TODO: handle exception
		}
		User ubf = udao.findById(uip.getUsersID());
		if (ubf != null) {
			boolean temp = uip.getUsersID().equals(ubf.getUsersID()) && uip.getPass().equals(ubf.getPass())
					&& uip.getFullName().equals(ubf.getFullName()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			
			t = temp;
		}else {
			t = false;
		}

		assertFalse(t);
	}

	@Test
	public void testUpdateNullname() {
		boolean t ;
		User uip = new User();
		try {

			uip.setUsersID("kienvt");
			uip.setPass("123456");
			uip.setFullName("");
			uip.setEmail("vtk@fpt.edu.vn");
			uip.setAdmin(false);
			udao.update(uip);

		} catch (Exception e) {
			// TODO: handle exception
		}
		User ubf = udao.findById(uip.getUsersID());
		if (ubf != null) {
			boolean temp = uip.getUsersID().equals(ubf.getUsersID()) && uip.getPass().equals(ubf.getPass())
					&& uip.getFullName().equals(ubf.getFullName()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			
			t = temp;
		}else {
			t = false;
		}

		assertFalse(t);
	}
	
	@Test
	public void testUpdateNullemail() {
		boolean t ;
		User uip = new User();
		try {

			uip.setUsersID("kienvt");
			uip.setPass("123456");
			uip.setFullName("Vũ Trung Kiên");
			uip.setEmail("");
			uip.setAdmin(false);
			udao.update(uip);

		} catch (Exception e) {
			// TODO: handle exception
		}
		User ubf = udao.findById(uip.getUsersID());
		if (ubf != null) {
			boolean temp = uip.getUsersID().equals(ubf.getUsersID()) && uip.getPass().equals(ubf.getPass())
					&& uip.getFullName().equals(ubf.getFullName()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			
			t = temp;
		}else {
			t = false;
		}

		assertFalse(t);
	}
	
	@Test
	public void testUpdateEmailError() {
		boolean t ;
		User uip = new User();
		try {

			uip.setUsersID("kienvt");
			uip.setPass("123456");
			uip.setFullName("Vũ Trung Kiên");
			uip.setEmail("vtk4019");
			uip.setAdmin(false);
			udao.update(uip);

		} catch (Exception e) {
			// TODO: handle exception
		}
		User ubf = udao.findById(uip.getUsersID());
		if (ubf != null) {
			boolean temp = uip.getUsersID().equals(ubf.getUsersID()) && uip.getPass().equals(ubf.getPass())
					&& uip.getFullName().equals(ubf.getFullName()) && uip.getEmail().equals(ubf.getEmail())
					&& uip.getAdmin() == ubf.getAdmin();
			
			t = temp;
		}else {
			t = false;
		}

		assertFalse(t);
	}
	
	@After
	public void afterUser() {

	}

	@AfterClass
	public static void CloseConnect() {

	}
}

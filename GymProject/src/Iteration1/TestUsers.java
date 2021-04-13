package Iteration1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestUsers {

	@Test
	void test() {
		Client user_1 = new Client("userid_1");
		
		user_1.setPassword("1234567");
		
		user_1.setUserType("supreUser");
		
		user_1.setSex( "Male");
		
		user_1.setPhone( "13176788165");
		
		user_1.loginLicense = true;
		user_1.userInfo[5] = "true";
		
		user_1.setRechargeAmount(180);
		
		
		user_1.setResume("I like Yoga");
		
		user_1.renewUserInfo();
		
		user_1 = new Client("userid_1");
		String userid = user_1.selectList.get(0)[0];
		
		assertEquals("userid_1", userid);
		
	}

}

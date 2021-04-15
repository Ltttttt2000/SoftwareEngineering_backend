package com.iot.g89;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestUsers {

	@Test
	void test() {
		
		//注册user_1
		Client user_1 = new Client("userid_1");
		
		user_1.setPassword("1234567");
	    user_1.setUserType("supreMember");
		user_1.setSex( "Male");
		user_1.setPhone( "13176788165");
		user_1.loginLicense = true;
		user_1.setRechargeAmount(180);
		user_1.setResume("I like Yoga");
		user_1.setAge(40);
		user_1.setChest(95);
		user_1.setHeight(189);
		user_1.setWeight(140);
		user_1.setWaist(12);
		user_1.setHip(56);
		
		//注册user_2
	    Client user_2 = new Client("userid_2");
        user_2.setPassword("987654321");
		user_2.setUserType("member");
		user_2.setSex( "FeMale");
		user_2.setPhone("15601159166");
		user_2.banThisAccount();
		user_2.setRechargeAmount(250);
		user_2.setResume("I like Running, hiking");
		user_2.setAge(20);
		user_2.setChest(85);
		user_2.setHeight(164);
		user_2.setWeight(95);
		user_2.setWaist(8);
		user_2.setHip(35);
		System.out.println("\n");
		
		Client user1 = new Client("userid_1");
		Client user2 = new Client("userid_2");
		
		Client user3 = new Client("userid_3");
		
		//注册instructor_1
		Instructor user_4 = new Instructor("instructor_1");
        user_4.setPassword("203534");
		user_4.setUserType("supremember");
		user_4.setSex( "FeMale");
		user_4.setPhone("15553756699");
		user_4.banThisAccount();
		user_4.setResume("I like playing");
		user_4.setAge(30);
		user_4.setChest(90);
		user_4.setHeight(170);
		user_4.setWeight(102);
		user_4.setWaist(10);
		user_4.setHip(25);
		user_4.setInstructorMoney(500);
		System.out.println("\n");
		
		//System.out.println(user1.entry);
		//System.out.println(user2.entry);
		assertEquals(40, user1.getAge() );
		
		assertEquals("15601159166", user2.getPhone());
		
		//登录 instructor
		user_4 = new Instructor("instructor_1");
		
		
		
	}

}

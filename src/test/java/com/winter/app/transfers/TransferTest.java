package com.winter.app.transfers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.winter.app.members.MembersVO;
import com.winter.app.transfer.Pay;
import com.winter.app.transfer.Transfers;

@SpringBootTest
class TransferTest {

	@Autowired
	private Transfers transfers;
	
	@Autowired
	private Pay pay;
	
	@Test
	void test() {
		
		transfers.takeBus("111");
		
		MembersVO memberVO = new MembersVO();
		memberVO.setUsername("user");
		memberVO=transfers.takeSubWay(memberVO);
		
	
		
	}

}

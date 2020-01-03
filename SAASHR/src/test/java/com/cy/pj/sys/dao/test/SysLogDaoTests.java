package com.cy.pj.sys.dao.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.TSysCodeMapper;
import com.cy.pj.sys.entity.TSysCode;

@SpringBootTest
public class SysLogDaoTests {
	
	
	
	@Test
	public void testGetRowCount() {
		System.out.println(12321321);
		//List<TSysCode> list = mapper.selectCodeTreeByChildren("0");
		//list.forEach(syscode -> System.out.println(syscode));
	}
	
}

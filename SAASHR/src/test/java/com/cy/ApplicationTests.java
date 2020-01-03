package com.cy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.TSysCodeMapper;
import com.cy.pj.sys.entity.TSysCode;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private TSysCodeMapper mapper;
	
	
	@Test
	public void testGetRowCount() {
		List<TSysCode> list = mapper.selectCodeTreeByChildren("XZQH");
		list.forEach(syscode -> System.out.println(syscode));
	}

	
	
	
}

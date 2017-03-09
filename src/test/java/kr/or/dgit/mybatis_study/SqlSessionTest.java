package kr.or.dgit.mybatis_study;

import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;
import kr.or.dgit.mybatis_study.util.MybatisSqlSessionFactory;

public class SqlSessionTest {
	private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sqlSessionFactory = null;
	}

	@Test
	public void test() {
		Assert.assertNotNull(sqlSessionFactory.openSession());
	}
}

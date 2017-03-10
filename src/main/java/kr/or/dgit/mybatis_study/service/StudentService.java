package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MybatisSqlSessionFactory;

public class StudentService {
	private static final StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}

	public StudentService() {}
	
	public List<Student> selectStudentByAll(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		//sqlSession.close();
		return studentDao.selectStudentByAll();
	}
	
	public int insertStudent(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		int res = studentDao.insertStudent(student);
		sqlSession.commit();
		return res;
	}
	
	public int insertSudentWithPhone(Student student){
		int res = -1;
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession();){
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			res = studentDao.insertSudentWithPhone(student);
			sqlSession.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/*public Student deleteStudentByNo(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		return studentDao.deleteStudentByNo(student);
	}*/
	
	//selectStudentByNo
	public Student selectStudentByNo(int studNo){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		return studentDao.selectStudentByNo(studNo);
		
	}
}

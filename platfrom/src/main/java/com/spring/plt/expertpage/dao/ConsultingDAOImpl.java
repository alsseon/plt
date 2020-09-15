package com.spring.plt.expertpage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.expertpage.vo.ConsultingVO;
import com.spring.plt.startuppage.vo.PageVO;

@Repository("consultingDAO")
public class ConsultingDAOImpl implements ConsultingDAO{
	private SqlSession sqlSession;
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.expertpage.listCount");
		System.out.println(listCount);
		return listCount;
	}
	@Override
	public List<ConsultingVO> selectAllEstiList(PageVO pagevo) throws DataAccessException{
		
		List<ConsultingVO> conList = null;
		conList = sqlSession.selectList("mapper.expertpage.selectAllEstilist",pagevo);
		
		return conList;
	}
	@Override
	public int deleteesti(int no) throws DataAccessException {
		int deleteesti = sqlSession.delete("mapper.expertpage.deleteesti", no);
		
		return deleteesti;
	}
	@Override
	public List<ConsultingVO> selectWaitEstiList(PageVO pagevo) throws DataAccessException{
		
		List<ConsultingVO> w_conList = null;
		w_conList = sqlSession.selectList("mapper.expertpage.selectWaitEstiList",pagevo);
		
		return w_conList;
	}
	@Override
	public List<ConsultingVO> selectIngEstiList(PageVO pagevo) throws DataAccessException{
		
		List<ConsultingVO> w_conList = null;
		w_conList = sqlSession.selectList("mapper.expertpage.selectIngEstiList",pagevo);
		
		return w_conList;
	}
	@Override
	public List<ConsultingVO> selectComEstiList(PageVO pagevo) throws DataAccessException{
		
		List<ConsultingVO> c_conList = null;
		c_conList = sqlSession.selectList("mapper.expertpage.selectComEstiList",pagevo);
		
		return c_conList;
	}
	@Override
	public List<ConsultingVO> selectDeEstiList(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> d_conList = null;
		d_conList = sqlSession.selectList("mapper.expertpage.selectAllEstilist",pagevo);
		
		return d_conList;
	}
}

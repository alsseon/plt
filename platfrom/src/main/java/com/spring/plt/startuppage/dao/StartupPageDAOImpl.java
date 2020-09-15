package com.spring.plt.startuppage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.startuppage.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Repository("startuppagedao")
public class StartupPageDAOImpl implements StartupPageDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int deleteesti(int no) throws DataAccessException {
		int deleteesti = sqlSession.delete("mapper.startuppage.deleteesti", no);
		System.out.println("dao : " + deleteesti);
		return deleteesti;
	}
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.startuppage.listCount");
		return listCount;
	}
	
	
	@Override
	public List<StartupPageVO> selectAllEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> estiList = null;
		estiList = sqlSession.selectList("mapper.startuppage.selectAllEstilist",pagevo);
		return estiList;
	}
	@Override
	public List<StartupPageVO> selectWaitEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> w_estiList = null;
		w_estiList = sqlSession.selectList("mapper.startuppage.selectWaitEstilist",pagevo);
		return w_estiList;
	}
	@Override
	public List<StartupPageVO> selectIngEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> i_estiList = null;
		i_estiList = sqlSession.selectList("mapper.startuppage.selectIngEstilist",pagevo);
		return i_estiList;
	}
	@Override
	public List<StartupPageVO> selectComEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> c_estiList = null;
		c_estiList = sqlSession.selectList("mapper.startuppage.selectComEstilist",pagevo);
		return c_estiList;
	}
	@Override
	public List<StartupPageVO> selectDeEstiList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> d_estiList = null;
		d_estiList = sqlSession.selectList("mapper.startuppage.selectDeEstilist",pagevo);
		return d_estiList;
	}
		
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<StartupPageVO> selectAllProdList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> prodList = null;
		prodList = sqlSession.selectList("mapper.startuppage.selectAllProdlist",pagevo);
		return prodList;
	}	
	@Override
	public List<StartupPageVO> selectAllConList(PageVO pagevo) throws DataAccessException{
		List<StartupPageVO> conList = null;
		conList = sqlSession.selectList("mapper.startuppage.selectAllConlist",pagevo);
		return conList;
	}
}

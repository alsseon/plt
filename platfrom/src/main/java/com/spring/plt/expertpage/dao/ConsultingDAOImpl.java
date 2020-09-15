package com.spring.plt.expertpage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.expertpage.vo.ConsultingVO;
import com.spring.plt.startuppage.vo.PageVO;

@Repository("consultingDAO")
public class ConsultingDAOImpl implements ConsultingDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int listCount() throws Exception{
		int listCount = sqlSession.selectOne("mapper.expertpage.listCount");
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
		
		List<ConsultingVO> i_conList = null;
		i_conList = sqlSession.selectList("mapper.expertpage.selectIngEstiList",pagevo);
		
		return i_conList;
	}
	@Override
	public List<ConsultingVO> selectComEstiList(PageVO pagevo) throws DataAccessException{
		
		List<ConsultingVO> c_conList = null;
		c_conList = sqlSession.selectList("mapper.expertpage.selectComEstilist",pagevo);
		
		return c_conList;
	}
	@Override
	public List<ConsultingVO> selectDeEstiList(PageVO pagevo) throws DataAccessException{
		List<ConsultingVO> d_conList = null;
		d_conList = sqlSession.selectList("mapper.expertpage.selectDeEstilist",pagevo);
		
		return d_conList;
	}
	public int status_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.expertpage.upstatus_esti_ing",no); //누르면 진행중으로 업데이트
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.expertpage.upstatus_esti_com",no);//완료로 업데이트ㄴ
		}
		return result;
	}
	public int status_n(int status, int no) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.expertpage.upstatus_esti_de",no);
		}
		return result;
	}
}

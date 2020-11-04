package com.spring.plt.expertpage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public int listCount_i(String expId) throws Exception{
		int listCount_i = sqlSession.selectOne("mapper.expertpage.listCount_i", expId);
		return listCount_i;
	}
	@Override
	public int listCount_w(String expId) throws Exception{
		int listCount_w = sqlSession.selectOne("mapper.expertpage.listCount_w", expId);
		return listCount_w;
	}
	@Override
	public int listCount_c(String expId) throws Exception{
		int listCount_c = sqlSession.selectOne("mapper.expertpage.listCount_c", expId);
		return listCount_c;
	}
	@Override
	public int listCount_d(String expId) throws Exception{
		int listCount_d = sqlSession.selectOne("mapper.expertpage.listCount_d", expId);
		return listCount_d;
	}
	
	
	
	
	@Override
	public List<ConsultingVO> selectAllEstiList(PageVO pagevo,String expId) throws DataAccessException{
		
		List<ConsultingVO> conList = null;
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		conList = sqlSession.selectList("mapper.expertpage.selectAllEstilist",consultingMap);
		
		return conList;
	}
	@Override
	public int deleteesti(int no) throws DataAccessException {
		int deleteesti = sqlSession.delete("mapper.expertpage.deleteesti", no);
		
		return deleteesti;
	}
	@Override
	public List<ConsultingVO> selectWaitEstiList(PageVO pagevo,String expId) throws DataAccessException{
		
		List<ConsultingVO> w_conList = null;
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		w_conList = sqlSession.selectList("mapper.expertpage.selectWaitEstiList",consultingMap);
		
		return w_conList;
	}
	@Override
	public List<ConsultingVO> selectIngEstiList(PageVO pagevo,String expId) throws DataAccessException{
		
		List<ConsultingVO> i_conList = null;
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		i_conList = sqlSession.selectList("mapper.expertpage.selectIngEstiList",consultingMap);
		
		return i_conList;
	}
	@Override
	public List<ConsultingVO> selectComEstiList(PageVO pagevo,String expId) throws DataAccessException{
		
		List<ConsultingVO> c_conList = null;
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		c_conList = sqlSession.selectList("mapper.expertpage.selectComEstilist",consultingMap);
		
		return c_conList;
	}
	@Override
	public List<ConsultingVO> selectDeEstiList(PageVO pagevo,String expId) throws DataAccessException{
		List<ConsultingVO> d_conList = null;
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		d_conList = sqlSession.selectList("mapper.expertpage.selectDeEstilist",consultingMap);
		
		return d_conList;
	}
	public int status_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.expertpage.upstatus_esti_ing",no); //������ ���������� ������Ʈ
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.expertpage.upstatus_esti_com",no);//�Ϸ�� ������Ʈ��
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

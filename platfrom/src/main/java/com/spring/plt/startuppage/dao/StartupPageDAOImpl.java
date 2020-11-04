package com.spring.plt.startuppage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public int deletecon(int no) throws DataAccessException {
		int deletecon = sqlSession.delete("mapper.startuppage.deletecon", no);
		return deletecon;
	}
	
	
	
	
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.startuppage.listCount");
		return listCount;
	}
	@Override
	public int estilistCount_i() throws Exception{
		int EstiListCount_i = sqlSession.selectOne("mapper.startuppage.estilistCount_i");
		return EstiListCount_i;
	}
	@Override
	public int estilistCount_w() throws Exception{
		int estilistCount_w = sqlSession.selectOne("mapper.startuppage.estilistCount_w");
		System.out.println("dao count" + estilistCount_w);
		return estilistCount_w;
	}
	@Override
	public int estilistCount_d() throws Exception{
		int EstiListCount_d = sqlSession.selectOne("mapper.startuppage.estilistCount_d");
		return EstiListCount_d;
	}
	@Override
	public int estilistCount_c() throws Exception{
		int EstiListCount_c = sqlSession.selectOne("mapper.startuppage.estilistCount_c");
		return EstiListCount_c;
	}
	
	
	
	
	@Override
	public List<StartupPageVO> selectAllEstiList(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> estiList = null;
		Map<String, Object> estilistMap = new HashMap<String, Object>();
		estilistMap.put("pagevo", pagevo);
		estilistMap.put("compId", compId);
		System.out.println("waitMap에 값이 다 들어있는지 확인"+estilistMap);
		estiList = sqlSession.selectList("mapper.startuppage.selectWaitEstilist",estilistMap);
		return estiList;
	}
	@Override
	public List<StartupPageVO> selectWaitEstiList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> w_estiList = null;
		Map<String, Object> waitMap = new HashMap<String, Object>();
		waitMap.put("pagevo", pagevo);
		waitMap.put("compId", compId);
		System.out.println("waitMap에 값이 다 들어있는지 확인"+waitMap);
		w_estiList = sqlSession.selectList("mapper.startuppage.selectWaitEstilist",waitMap);
		return w_estiList;
	}
	@Override
	public List<StartupPageVO> selectIngEstiList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> i_estiList = null;
		Map<String, Object> ingMap = new HashMap<String, Object>();
		ingMap.put("pagevo", pagevo);
		ingMap.put("compId", compId);
		i_estiList = sqlSession.selectList("mapper.startuppage.selectIngEstilist",ingMap);
		return i_estiList;
	}
	@Override
	public List<StartupPageVO> selectComEstiList(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> c_estiList = null;
		Map<String, Object> completeMap = new HashMap<String, Object>();
		completeMap.put("pagevo", pagevo);
		completeMap.put("compId", compId);
		System.out.println("waitMap에 값이 다 들어있는지 확인"+completeMap);
		c_estiList = sqlSession.selectList("mapper.startuppage.selectWaitEstilist",completeMap);
		return c_estiList;
	}
	@Override
	public List<StartupPageVO> selectDeEstiList(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> d_estiList = null;
		Map<String, Object> deMap = new HashMap<String, Object>();
		deMap.put("pagevo", pagevo);
		deMap.put("compId", compId);
		System.out.println("waitMap에 값이 다 들어있는지 확인"+deMap);
		d_estiList = sqlSession.selectList("mapper.startuppage.selectWaitEstilist",deMap);
		return d_estiList;
	}
		
	
	
	
	
	
	public int status_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_ing",no); //������ ���������� ������Ʈ
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_com",no);//�Ϸ�� ������Ʈ��
		}
		return result;
	}
	public int status_n(int status, int no) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_de",no);
		}
		return result;
	}
	
	
	
	
	public int constatus_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_ing",no); //������ ���������� ������Ʈ
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_com",no);//�Ϸ�� ������Ʈ��
		}
		return result;
	}
	public int constatus_n(int status, int no) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_de",no);
		}
		return result;
	}
	
	
	
	
	@Override
	public int conlistCount_i() throws Exception{
		int conlistCount_i = sqlSession.selectOne("mapper.startuppage.conlistCount_i");
		return conlistCount_i;
	}
	@Override
	public int conlistCount_w() throws Exception{
		int conlistCount_w = sqlSession.selectOne("mapper.startuppage.conlistCount_w");
		return conlistCount_w;
	}
	@Override
	public int conlistCount_d() throws Exception{
		int conlistCount_d = sqlSession.selectOne("mapper.startuppage.conlistCount_d");
		return conlistCount_d;
	}
	@Override
	public int conlistCount_c() throws Exception{
		int conlistCount_c = sqlSession.selectOne("mapper.startuppage.conlistCount_c");
		return conlistCount_c;
	}
	@Override
	public List<StartupPageVO> selectAllConList(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> conList = null;
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("compId", compId);
		System.out.println("waitMap에 값이 다 들어있는지 확인"+consultingMap);
		conList = sqlSession.selectList("mapper.startuppage.selectAllConlist",consultingMap);
		System.out.println(consultingMap);
		return conList;
	}
	@Override
	public List<StartupPageVO> selectWaitConList(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> w_conList = null;
		Map<String, Object> w_consultingMap = new HashMap<String, Object>();
		w_consultingMap.put("pagevo", pagevo);
		w_consultingMap.put("compId", compId);
		w_conList = sqlSession.selectList("mapper.startuppage.selectWaitConlist",w_consultingMap);
		System.out.println("확인" + w_conList);
		return w_conList;
	}
	public List<StartupPageVO> selectIngConList(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> i_conList = null;
		Map<String, Object> i_consultingMap = new HashMap<String, Object>();
		i_consultingMap.put("pagevo", pagevo);
		i_consultingMap.put("compId", compId);
		System.out.println("waitMap에 값이 다 들어있는지 확인"+i_consultingMap);
		i_conList = sqlSession.selectList("mapper.startuppage.selectIngConlist",i_consultingMap);
		
		return i_conList;
	}
	public List<StartupPageVO> selectComConList(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> c_conList = null;
		Map<String, Object> c_consultingMap = new HashMap<String, Object>();
		c_consultingMap.put("pagevo", pagevo);
		c_consultingMap.put("compId", compId);
		System.out.println("waitMap에 값이 다 들어있는지 확인"+c_consultingMap);
		c_conList = sqlSession.selectList("mapper.startuppage.selectComConlist",c_consultingMap);
		
		return c_conList;
	}
	public List<StartupPageVO> selectDeConList(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> d_conList = null;
		Map<String, Object> d_consultingMap = new HashMap<String, Object>();
		d_consultingMap.put("pagevo", pagevo);
		d_consultingMap.put("compId", compId);
		System.out.println("waitMap에 값이 다 들어있는지 확인"+d_consultingMap);
		d_conList = sqlSession.selectList("mapper.startuppage.selectDeConlist",d_consultingMap);
		
		return d_conList;
	}
	
}

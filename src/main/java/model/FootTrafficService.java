package model;

import java.util.List;

import model.dto.AreaDTO;
import model.dto.FootTrafficDTO;

public class FootTrafficService {
	private static FootTrafficService instance = new FootTrafficService();

	private FootTrafficService() {
	}

	public static FootTrafficService getInstance() {
		return instance;
	}

	// 지역정보 insert
	public boolean insertArea(String areaName, String sigungu) throws Exception {
		return AreaDAO.insertArea(areaName, sigungu);
	}

	// 지역정보 전체 검색
	public List<AreaDTO> selectAllArea() throws Exception {
		return AreaDAO.selectAllArea();
	}

	// 지역정보 개별 검색
	public AreaDTO selectArea(String areaName) throws Exception {
		return AreaDAO.selectArea(areaName);
	}

	// 지역정보 구이름으로 select
	public List<AreaDTO> selectFromGu(String sigungu) throws Exception {
		return AreaDAO.selectFromGu(sigungu);
	}

	// 지역정보 update
	public boolean updateArea(String areaName, String sigungu) throws Exception {
		return AreaDAO.updateArea(areaName, sigungu);
	}
	
	// 지역정보 delete
	public boolean deleteArea(String areaName) throws Exception {
		return AreaDAO.deleteArea(areaName);
	}

	// ==========================================================================

	// 유동인구 insert
	public boolean insertFootTraffic(String gender, String day, int times, int ft, AreaDTO area) throws Exception {
		return FootTrafficDAO.insertFootTraffic(gender, day, times, ft, area);
	}

	// 유동인구 전체 검색
	public List<FootTrafficDTO> selectAllFoot() throws Exception {
		return FootTrafficDAO.selectAllFoot();
	}

	// 유동인구 개별 검색
	public FootTrafficDTO selectTraffic(int id) throws Exception {
		return FootTrafficDAO.selectTraffic(id);
	}

	// 유동인구 지역 PK로 검색
	public List<FootTrafficDTO> selectFromArea(String areaName) throws Exception {
		return FootTrafficDAO.selectFromArea(areaName);
	}

	// 유동인구 update
	public boolean updateTraffic(int id, int ft) throws Exception {
		return FootTrafficDAO.updateTraffic(id, ft);
	}

	// 유동인구 지역 PK로 삭제
	public boolean deleteTraffic(String areaName) throws Exception {
		return FootTrafficDAO.deleteTraffic(areaName);
	}
}

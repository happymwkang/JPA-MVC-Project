package service;

import java.util.List;

import model.FootTrafficService;
import model.dto.AreaDTO;
import model.dto.FootTrafficDTO;
import view.EndView;
import view.FailView;

public class Controller {

	private static Controller instance = new Controller();
	private FootTrafficService service = FootTrafficService.getInstance();

	private Controller() {
	}

	public static Controller getInstance() {
		return instance;
	}

	// 지역정보 insert
	public void insertArea(String areaName, String sigungu) {
		try {
			if(service.insertArea(areaName, sigungu)) {
				EndView.printMessage("저장성공");
			}
		} catch (Exception e)  {
			e.printStackTrace();
			FailView.printFailMessage("저장실패");
		}
	}

	// 지역정보 전체 검색
	public void selectAllArea() {
		try {
			EndView.printAreaList(service.selectAllArea());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 지역정보 개별 검색
	public void selectArea(String areaName) {
		try {
			EndView.printArea(service.selectArea(areaName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 지역정보 구이름으로 select
	public void selectFromGu(String sigungu) {
		try {
			EndView.printAreaList(service.selectFromGu(sigungu));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 지역정보 update
	public void updateArea(String areaName, String sigungu) {
		try {
			if(service.updateArea(areaName, sigungu)) {
				EndView.printMessage("수정성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printFailMessage("수정실패");
		}
	}

	// 지역정보 delete
	public void deleteArea(String areaName){
		try {
			if(service.deleteArea(areaName)) {
				EndView.printMessage("삭제성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printFailMessage("삭제실패");
		}
	}

	// ==========================================================================

	// 유동인구 insert
	public void insertFootTraffic(String gender, String day, int times, int ft, AreaDTO area) {
		try {
			if(service.insertFootTraffic(gender, day, times, ft, area)) {
				EndView.printMessage("저장성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printFailMessage("저장실패");
		}
	}

	// 유동인구 전체 검색
	public void selectAllFoot() {
		try {
			EndView.printTrafficList(service.selectAllFoot());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 유동인구 개별 검색
	public void selectTraffic(int id) {
		try {
			EndView.printTraffic(service.selectTraffic(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 유동인구 구 이름으로 검색
	public void selectFromArea(String areaName) {
		try {
			EndView.printTrafficList(service.selectFromArea(areaName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 유동인구 update
	public void updateTraffic(int id, int ft) {
		try {
			if (service.updateTraffic(id, ft)) {
				EndView.printMessage("수정성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printFailMessage("수정실패");
		}
	}

	// 유동인구 컬럼값 기준으로 삭제
	public void deleteTraffic(String areaName) {
		try {
			if (service.deleteTraffic(areaName)) {
				EndView.printMessage("삭제성공");
			} else if(!service.deleteTraffic(areaName)){
				FailView.printFailMessage("삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printFailMessage("삭제실패");
		}
	}
}

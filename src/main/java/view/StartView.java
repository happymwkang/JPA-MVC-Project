package view;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import model.AreaDAO;
import service.Controller;
import util.FileReaders;
import util.ManagerFactory;

public class StartView {
	private static Controller controller = Controller.getInstance();
	public static void main(String[] args) throws NumberFormatException, Exception {
			try {
				List<String> aList = Files.readAllLines(FileReaders.path1, FileReaders.cs);
				List<String> fList = Files.readAllLines(FileReaders.path2, FileReaders.cs);
//				
				//지역정보 insert
				for(int i = 1; i < aList.size(); i++) {
					controller.insertArea(aList.get(i).split("	")[0], aList.get(i).split("	")[1]);
				}
				// 유동인구 insert
				for(int i = 1; i < fList.size(); i++) {
					controller.insertFootTraffic(fList.get(i).split("	")[1], fList.get(i).split("	")[3], Integer.parseInt(fList.get(i).split("	")[4]), Integer.parseInt(fList.get(i).split("	")[5]), AreaDAO.selectArea(fList.get(i).split("	")[0]));
				}
				
//				//지역정보 전체 검색
//				controller.selectAllArea();
//				
//				//유동인구 전체 검색
//				controller.selectAllFoot();
				
				//지역정보 update
//				controller.updateArea("방학로5길", "엔코아");
//				controller.selectArea("방학로5길");
				
				//유동인구 update
//				controller.updateTraffic(7056, 2000);
//				controller.selectTraffic(7056);
//				
				
				//유동인구, 지역정보 delete
//				controller.deleteTraffic("학동로77길");
//				controller.deleteArea("학동로77길");
//				controller.selectAllFoot();
//				controller.selectAllArea();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				ManagerFactory.factory.close();
			}
		
	}

}

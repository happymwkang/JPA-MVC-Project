package view;

import java.util.List;

import model.dto.AreaDTO;
import model.dto.FootTrafficDTO;

public class EndView {
	public static void printAreaList(List<AreaDTO> list) {
		for (AreaDTO a : list) {
			System.out.println(a);
		}
	}

	public static void printTrafficList(List<FootTrafficDTO> list) {
		for (FootTrafficDTO a : list) {
			System.out.println(a);
		}
	}

	public static void printArea(AreaDTO area) {
		System.out.println(area);
	}

	public static void printTraffic(FootTrafficDTO footTraffic) {
		System.out.println(footTraffic);
	}

	public static void printMessage(String m) {
		System.out.println(m);
	}
}

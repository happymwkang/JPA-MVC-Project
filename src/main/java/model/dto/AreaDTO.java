package model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AreaDTO {
	
	@Id
	@Column(name = "AREA_NAME", length = 100)
	private String areaName;
	
	@Column(length = 30)
	private String sigungu;
	
	@OneToMany(mappedBy = "area")
	private List<FootTrafficDTO> traffic = new ArrayList<FootTrafficDTO>();
	
	@Override
	public String toString() {
		return "areaName : " + areaName + "  sigungu : " + sigungu;
	}

	public AreaDTO(String areaName, String sigungu) {
		super();
		this.areaName = areaName;
		this.sigungu = sigungu;
	}
}

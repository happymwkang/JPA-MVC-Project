package model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "AREA_FOOT_TRAFFIC")
public class FootTrafficDTO {
	@Id
	@GeneratedValue(generator = "FOOT_TRAFFIC_SEQ")
	private int id;

	@Column(length = 2)
	private String gender;

	@Column(length = 5)
	private String day;
	private int times;
	private int ft;

	@ManyToOne
	@JoinColumn(name = "areaName")
	private AreaDTO area;
	
	public FootTrafficDTO(String gender, String day, int times, int ft, AreaDTO area) {
		super();
		this.gender = gender;
		this.day = day;
		this.times = times;
		this.ft = ft;
		this.area = area;
	}

}

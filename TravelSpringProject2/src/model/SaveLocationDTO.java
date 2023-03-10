package model;

import java.util.List;

/**
 * 여행지
 * field : id, name, imageList, contents
 * 
 * 저장한 여행지 (=장바구니)
 * data
 * @author anyware
 *
 */
public class SaveLocationDTO {

	private String id;
	private int locationNum;
	
	//join table location 
	private String locationName; 	//여행지명 (장바구니 상품명같은 것.) 
	
	//이미지
	private String picture;
	//private List imageList;
	
	//도도부현
	private String prefecture;
	
	//지역
	private String region;
	
	//속성
	private String type;
	
	//계절
	private String season;

	public String getId() {
		return id;
	}

	public int getLocationNum() {
		return locationNum;
	}

	public String getLocationName() {
		return locationName;
	}

	public String getPicture() {
		return picture;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public String getRegion() {
		return region;
	}

	public String getType() {
		return type;
	}

	public String getSeason() {
		return season;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLocationNum(int locationNum) {
		this.locationNum = locationNum;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "SaveLocationDTO [id=" + id + ", locationNum=" + locationNum + ", locationName=" + locationName
				+ ", picture=" + picture + ", prefecture=" + prefecture + ", region=" + region + ", type=" + type
				+ ", season=" + season + "]";
	}

	//id만
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaveLocationDTO other = (SaveLocationDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

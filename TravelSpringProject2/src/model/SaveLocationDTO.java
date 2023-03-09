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
	private int locationNum; //bookid
	
	//join table location 
	private String locationName; 	//여행지명 (장바구니 상품명같은 것.) bookname
	
	//이미지
	private List imageList;
	

	public String getId() {
		return id;
	}

	public int getLocationNum() {
		return locationNum;
	}

	public List getImageList() {
		return imageList;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLocationNum(int locationNum) {
		this.locationNum = locationNum;
	}

	public void setImageList(List imageList) {
		this.imageList = imageList;
	}
	
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		return "SaveLocationDTO [id=" + id + ", locationNum=" + locationNum + ", locationName=" + locationName
				+ ", imageList=" + imageList + "]";
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

package model;
/**
 * 저장한 여행지 (=장바구니)
 * data
 * @author anyware
 *
 */
public class SaveLocationDTO {

	private String id;
	private int locationNum;
	
	//join table location 
	private String region; 	//여행지명 (장바구니 상품명같은 것.)

	public String getId() {
		return id;
	}

	public int getLocationNum() {
		return locationNum;
	}

	public String getRegion() {
		return region;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLocationNum(int locationNum) {
		this.locationNum = locationNum;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "SaveLocationDTO [id=" + id + ", locationNum=" + locationNum + ", region=" + region + "]";
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

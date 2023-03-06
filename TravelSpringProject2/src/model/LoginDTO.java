package model;
/**
 * data
 * @author anyware
 *
 */
public class LoginDTO {
	private String id;
	private int pwd;
	private String name;
	private String birth;
	private String gender;
	private String mail;
	private int phone;
	private String address;

	public String getId() {
		return id;
	}
	public int getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	public String getGender() {
		return gender;
	}
	public String getMail() {
		return mail;
	}
	public int getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", birth=" + birth + ", gender=" + gender
				+ ", email=" + mail + ", phone=" + phone + ", address=" + address + "]";
	}
	
	//hashCode, equals는 id로만
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
		LoginDTO other = (LoginDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

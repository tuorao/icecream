/*
* 작성일 : 2015. 7. 9.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.dto;

public class CustomerDTO {

	private int srl;				// 회원 고유번호
	private String id;				// 회원 id
	private String password;		// 회원 password
	private String name;			// 회원 이름
	private int age;				// 회원 나이
	private String phone;			// 회원 전화번호
	private String joindate;		// 회원가입 날짜
	private String lastlogindate;	// 마지막 로그인 날짜
	private String alterdate;		// 회원정보 변경 일자
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getLastlogindate() {
		return lastlogindate;
	}
	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}
	public String getAlterdate() {
		return alterdate;
	}
	public void setAlterdate(String alterdate) {
		this.alterdate = alterdate;
	}
	@Override
	public String toString() {
		return "CustomerDTO [srl=" + srl + ", id=" + id + ", password="
				+ password + ", name=" + name + ", age=" + age + ", phone="
				+ phone + ", joindate=" + joindate + ", lastlogindate="
				+ lastlogindate + ", alterdate=" + alterdate + "]";
	}
}

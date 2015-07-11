/*
* 작성일 : 2015. 7. 11.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.dto;

public class CustomerpayrecordDTO {
	private int srl;
	private String sort;
	private int payedmoney;
	private String usedate;
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getPayedmoney() {
		return payedmoney;
	}
	public void setPayedmoney(int payedmoney) {
		this.payedmoney = payedmoney;
	}
	public String getUsedate() {
		return usedate;
	}
	public void setUsedate(String usedate) {
		this.usedate = usedate;
	}
	@Override
	public String toString() {
		return "PayedmoneyDTO [srl=" + srl + ", sort=" + sort + ", payedmoney="
				+ payedmoney + ", usedate=" + usedate + "]";
	}
	
}

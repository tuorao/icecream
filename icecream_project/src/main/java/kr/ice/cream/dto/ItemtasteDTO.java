/*
* 작성일 : 2015. 7. 10.
* 작성자 : Administrator
*
* 설명
*/
package kr.ice.cream.dto;

public class ItemtasteDTO {

	private int srl;		// 고유번호
	private int itemsrl;	// item 외래키
	private int sweet;		// 단맛
	private int soft;		// 부드러운맛
	private int sour;		// 새콤한맛
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getItemsrl() {
		return itemsrl;
	}
	public void setItemsrl(int itemsrl) {
		this.itemsrl = itemsrl;
	}
	public int getSweet() {
		return sweet;
	}
	public void setSweet(int sweet) {
		this.sweet = sweet;
	}
	public int getSoft() {
		return soft;
	}
	public void setSoft(int soft) {
		this.soft = soft;
	}
	public int getSour() {
		return sour;
	}
	public void setSour(int sour) {
		this.sour = sour;
	}
	@Override
	public String toString() {
		return "ItemtasteDTO [srl=" + srl + ", itemsrl=" + itemsrl + ", sweet="
				+ sweet + ", soft=" + soft + ", sour=" + sour + "]";
	}
	
}

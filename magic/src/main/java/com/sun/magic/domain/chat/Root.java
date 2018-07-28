package com.sun.magic.domain.chat;
//import java.util.List;
/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月28日 下午4:15:09
 */
public class Root {

	private Base_resp base_resp;

	private java.util.List<com.sun.magic.domain.chat.List> list;

	private int total;

	public void setBase_resp(Base_resp base_resp) {
		this.base_resp = base_resp;
	}

	public Base_resp getBase_resp() {
		return this.base_resp;
	}

	public void setList(java.util.List<com.sun.magic.domain.chat.List> list) {
		this.list = list;
	}

	public java.util.List<com.sun.magic.domain.chat.List> getList() {
		return this.list;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return this.total;
	}

	@Override
	public String toString() {
		return "Root [base_resp=" + base_resp + ", list=" + list + ", total="
				+ total + "]";
	}
	
	
}

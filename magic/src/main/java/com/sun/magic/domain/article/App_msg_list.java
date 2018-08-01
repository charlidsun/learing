package com.sun.magic.domain.article;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年8月1日 下午1:16:49
 */
public class App_msg_list {
	private String aid;
	private long appmsgid;
	private String cover;
	private String digest;
	private int itemidx;
	private String link;
	private String title;
	private long update_time;

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAid() {
		return aid;
	}

	public void setAppmsgid(long appmsgid) {
		this.appmsgid = appmsgid;
	}

	public long getAppmsgid() {
		return appmsgid;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getCover() {
		return cover;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getDigest() {
		return digest;
	}

	public void setItemidx(int itemidx) {
		this.itemidx = itemidx;
	}

	public int getItemidx() {
		return itemidx;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}

	public long getUpdate_time() {
		return update_time;
	}
}

package pojo;

import java.io.Serializable;
public class Picture implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer picId;
	private String picPath;
	private String picName;
	private Integer picOrder;//之前命名为order，属于mySQL关键字，insert sql无法执行成功（找了近两天，泪）
	
	public Integer getPicId() {
		return picId;
	}
	public void setPicId(Integer picId) {
		this.picId = picId;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public Integer getPicOrder() {
		return picOrder;
	}
	public void setPicOrder(Integer picOrder) {
		this.picOrder = picOrder;
	}

}

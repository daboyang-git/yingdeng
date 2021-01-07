package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页查询实体类
 * @author ChenHao
 *
 * @param <T>
 */
@Setter
@Getter
@ToString
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**当前页默认为1*/
	private Integer pageIndex = 1;
	/**页容量默认为10*/
	private Integer pageSize = 10;
	/**总记录数*/
	private Integer pageCount;
	/**总页数*/
	private Integer pageTotal;
	/**查询出来的表的集合*/
	private List<T> pageDatas;
	
	public Integer getPageTotal() {
		return pageCount % pageSize == 0 ? pageCount / pageSize : pageCount / pageSize + 1;
	}
}

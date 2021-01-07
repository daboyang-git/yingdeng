package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 核对结果信息表
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class CheckResult implements Serializable {

	private static final long serialVersionUID = 1L;
	/**主键*/
	private Integer id;
	/**主动创建时间*/
	private Date timeCreate;
	/**被动修改时间*/
	private Date timeModified;
	/**状态,软删除*/
	private Integer state;
	/**乐观锁版本号*/
	private Integer version;
	/**审核结果  1 失败   2  成功*/
	private Integer result;
	/**提示信息 成功无提示信息*/
	private String remark;
	/**资产表id*/
	private String assetId;
}

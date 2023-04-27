package com.bosssoft.hr.train.j2se.pojo.entity.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Dazo
 */
public class BaseEntity implements Serializable {
    /**
     * 主键
     */
    protected Long id;
    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 机构id  一个租户多个机构
     */
    private Long orgId;
    /**
     * 公司id  一个机构多个公司
     */
    private Long companyId;
    /**
     * 创建人id  此id指出主键值
     */
    private Long createBy;
    /**
     * 姓名  关联查询
     */
    private String creator;
    /**
     * 记录插入的记录时间  用于追踪记录
     */
    private Date createdTime;
    /**
     * 修改人id
     */
    private Long updatedBy;
    /**
     * 记录更新的记录时间  用于追踪记录更新时间  确认是否最新时间在首位
     */
     private Date updatedTime;
    /**
     * 修改人
     */
     private Long modifier;
    /**
     * 记录状态  正常为1  注销为0
     */
    private  byte status;
    /**
     * 记录版本号  累加
     */
    private Long version;

    public BaseEntity(Long id, Long tenantId, Long orgId, Long companyId, Long createdBy, String creator, Date createdTime, Long updatedBy, Date updatedTime, String modifier, byte status, Long version) {


    }

    public BaseEntity() {

    }

    public Long getId() {
        return id;
    }


}

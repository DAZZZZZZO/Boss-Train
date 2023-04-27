package com.bosssoft.hr.train.j2se.pojo.entity.pojo;


import java.util.Date;

/**
 **
 */
public class Role extends BaseEntity {
    /**
     * 姓名
     */
    private String name;
    /**
     * 角色编号
     */
    private String code;
    /**
     * 角色备注
     */
    private String remark;

    public Role(Long id, Long tenantId, Long orgId, Long companyId, Long createdBy, String creator, Date createdTime, Long updatedBy, Date updatedTime, String modifier, byte status, Long version) {
        super(id, tenantId, orgId, companyId, createdBy, creator, createdTime, updatedBy, updatedTime, modifier, status, version);
    }
}

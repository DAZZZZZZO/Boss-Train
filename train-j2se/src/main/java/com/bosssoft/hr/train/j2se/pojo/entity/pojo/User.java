package com.bosssoft.hr.train.j2se.pojo.entity.pojo;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @version 1.0
 * @class: User
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午3:58
 */
public class User extends BaseEntity {
    /**
     * 用户拥有多个角色，采用set而不是list为避免role对象重复
     */
    private Set<Role> roles;
    /**
     * 编号
     */
    private String code;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String profilePicture;
    /**
     * 生日  采用Util.date
     */
    private Date birthday;
    /**
     * 电话号码
     */
    private String tel;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 其他
     */
    private String other;
    /**
     * 备注
     */
    private String remark;
    /**
     * 部门id
     */
    private Long departmentId;
    /**
     * 职位id
     */
    private Long positionId;
    private int age;

    public User(Long id, String code, String name) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public User(Long id, Long tenantId, Long orgId, Long companyId, Long createdBy, String creator, Date createdTime, Set<Role> roles, String code, String name, String password, String profilePicture, Date birthday) {
        this.roles = roles;
        this.code = code;
        this.name = name;
        this.password = password;
        this.profilePicture = profilePicture;
        this.birthday = birthday;
        this.departmentId = null;
        this.positionId = null;
        this.email = null;
        this.tel = null;
        this.other = null;
        this.remark = null;
    }

    public User(int i, String s) {
    }

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(code, user.code) &&
                Objects.equals(name, user.name)&&
                Objects.equals(id,user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, name,id,roles);
    }


    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


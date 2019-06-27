package com.alpha.heroku.test.entity;

import javax.persistence.*;

@Table(name = "my_first")
public class MyFirst {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * 分组
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return first_name - 名称
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置名称
     *
     * @param firstName 名称
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    /**
     * 获取分组
     *
     * @return group_name - 分组
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置分组
     *
     * @param groupName 分组
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }
}
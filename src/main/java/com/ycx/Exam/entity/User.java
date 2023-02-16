package com.ycx.Exam.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_id
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private Long userNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_name
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.age
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.sex
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_level
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private Integer userLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.birth_day
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private Date birthDay;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.phone
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.role
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private Integer role;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.status
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.create_time
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.modify_time
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.create_user
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.update_user
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.deleted
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_id
     *
     * @return the value of t_user.user_id
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Long getUserNo() {
        return userNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_id
     *
     * @param userNo the value for t_user.user_id
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_name
     *
     * @return the value of t_user.user_name
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_name
     *
     * @param userName the value for t_user.user_name
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.age
     *
     * @return the value of t_user.age
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.age
     *
     * @param age the value for t_user.age
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.sex
     *
     * @return the value of t_user.sex
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.sex
     *
     * @param sex the value for t_user.sex
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_level
     *
     * @return the value of t_user.user_level
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_level
     *
     * @param userLevel the value for t_user.user_level
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.birth_day
     *
     * @return the value of t_user.birth_day
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Date getBirthDay() {
        return birthDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.birth_day
     *
     * @param birthDay the value for t_user.birth_day
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.phone
     *
     * @return the value of t_user.phone
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.phone
     *
     * @param phone the value for t_user.phone
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.role
     *
     * @return the value of t_user.role
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Integer getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.role
     *
     * @param role the value for t_user.role
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.status
     *
     * @return the value of t_user.status
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.status
     *
     * @param status the value for t_user.status
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.create_time
     *
     * @return the value of t_user.create_time
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.create_time
     *
     * @param createTime the value for t_user.create_time
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.modify_time
     *
     * @return the value of t_user.modify_time
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.modify_time
     *
     * @param modifyTime the value for t_user.modify_time
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.create_user
     *
     * @return the value of t_user.create_user
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.create_user
     *
     * @param createUser the value for t_user.create_user
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.update_user
     *
     * @return the value of t_user.update_user
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.update_user
     *
     * @param updateUser the value for t_user.update_user
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.deleted
     *
     * @return the value of t_user.deleted
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.deleted
     *
     * @param deleted the value for t_user.deleted
     *
     * @mbggenerated Sun Feb 12 11:40:07 CST 2023
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
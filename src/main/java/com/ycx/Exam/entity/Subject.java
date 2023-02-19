package com.ycx.Exam.entity;

import java.io.Serializable;

public class Subject implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.id
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
//    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.name
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.level
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.level_name
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    private String levelName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.deleted
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.item_order
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    private Integer itemOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table subject
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.id
     *
     * @return the value of subject.id
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.id
     *
     * @param id the value for subject.id
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.name
     *
     * @return the value of subject.name
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.name
     *
     * @param name the value for subject.name
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.level
     *
     * @return the value of subject.level
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.level
     *
     * @param level the value for subject.level
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.level_name
     *
     * @return the value of subject.level_name
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.level_name
     *
     * @param levelName the value for subject.level_name
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.deleted
     *
     * @return the value of subject.deleted
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.deleted
     *
     * @param deleted the value for subject.deleted
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.item_order
     *
     * @return the value of subject.item_order
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public Integer getItemOrder() {
        return itemOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.item_order
     *
     * @param itemOrder the value for subject.item_order
     *
     * @mbggenerated Wed Feb 15 13:19:47 CST 2023
     */
    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }
}
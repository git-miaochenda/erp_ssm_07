package com.erp.pojo;

public class GoodsType {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_type.uuid
     *
     * @mbg.generated Mon Apr 26 22:11:37 CST 2021
     */
    private Integer uuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods_type.name
     *
     * @mbg.generated Mon Apr 26 22:11:37 CST 2021
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_type.uuid
     *
     * @return the value of goods_type.uuid
     *
     * @mbg.generated Mon Apr 26 22:11:37 CST 2021
     */
    public Integer getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_type.uuid
     *
     * @param uuid the value for goods_type.uuid
     *
     * @mbg.generated Mon Apr 26 22:11:37 CST 2021
     */
    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods_type.name
     *
     * @return the value of goods_type.name
     *
     * @mbg.generated Mon Apr 26 22:11:37 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods_type.name
     *
     * @param name the value for goods_type.name
     *
     * @mbg.generated Mon Apr 26 22:11:37 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
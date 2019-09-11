package com.pojo;

import java.io.Serializable;

public class Group implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_group.smallgroup
     *
     * @mbggenerated
     */
    private String smallgroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_group.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_group
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_group.smallgroup
     *
     * @return the value of tb_group.smallgroup
     *
     * @mbggenerated
     */
    public String getSmallgroup() {
        return smallgroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_group.smallgroup
     *
     * @param smallgroup the value for tb_group.smallgroup
     *
     * @mbggenerated
     */
    public void setSmallgroup(String smallgroup) {
        this.smallgroup = smallgroup == null ? null : smallgroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_group.description
     *
     * @return the value of tb_group.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_group.description
     *
     * @param description the value for tb_group.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_group
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Group other = (Group) that;
        return (this.getSmallgroup() == null ? other.getSmallgroup() == null : this.getSmallgroup().equals(other.getSmallgroup()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_group
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSmallgroup() == null) ? 0 : getSmallgroup().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_group
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", smallgroup=").append(smallgroup);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
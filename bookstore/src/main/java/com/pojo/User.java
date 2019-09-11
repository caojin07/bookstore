package com.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.inumber
     *
     * @mbggenerated
     */
    private String inumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.password
     *
     * @mbggenerated
     */
    private String password;
    private String password_mw;
    public String getPassword_mw() {
		return password_mw;
	}

	public void setPassword_mw(String password_mw) {
		this.password_mw = password_mw;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.gender
     *
     * @mbggenerated
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.comment
     *
     * @mbggenerated
     */
    private String comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.location
     *
     * @mbggenerated
     */
    private String location;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.smallgroup
     *
     * @mbggenerated
     */
    private String smallgroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.birthday
     *
     * @mbggenerated
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.id
     *
     * @return the value of tb_user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.id
     *
     * @param id the value for tb_user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.inumber
     *
     * @return the value of tb_user.inumber
     *
     * @mbggenerated
     */
    public String getInumber() {
        return inumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.inumber
     *
     * @param inumber the value for tb_user.inumber
     *
     * @mbggenerated
     */
    public void setInumber(String inumber) {
        this.inumber = inumber == null ? null : inumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.username
     *
     * @return the value of tb_user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.username
     *
     * @param username the value for tb_user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.password
     *
     * @return the value of tb_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.password
     *
     * @param password the value for tb_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.gender
     *
     * @return the value of tb_user.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.gender
     *
     * @param gender the value for tb_user.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.comment
     *
     * @return the value of tb_user.comment
     *
     * @mbggenerated
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.comment
     *
     * @param comment the value for tb_user.comment
     *
     * @mbggenerated
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.location
     *
     * @return the value of tb_user.location
     *
     * @mbggenerated
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.location
     *
     * @param location the value for tb_user.location
     *
     * @mbggenerated
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.smallgroup
     *
     * @return the value of tb_user.smallgroup
     *
     * @mbggenerated
     */
    public String getSmallgroup() {
        return smallgroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.smallgroup
     *
     * @param smallgroup the value for tb_user.smallgroup
     *
     * @mbggenerated
     */
    public void setSmallgroup(String smallgroup) {
        this.smallgroup = smallgroup == null ? null : smallgroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.birthday
     *
     * @return the value of tb_user.birthday
     *
     * @mbggenerated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.birthday
     *
     * @param birthday the value for tb_user.birthday
     *
     * @mbggenerated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInumber() == null ? other.getInumber() == null : this.getInumber().equals(other.getInumber()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getSmallgroup() == null ? other.getSmallgroup() == null : this.getSmallgroup().equals(other.getSmallgroup()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInumber() == null) ? 0 : getInumber().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getSmallgroup() == null) ? 0 : getSmallgroup().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", inumber=").append(inumber);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", gender=").append(gender);
        sb.append(", comment=").append(comment);
        sb.append(", location=").append(location);
        sb.append(", smallgroup=").append(smallgroup);
        sb.append(", birthday=").append(birthday);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
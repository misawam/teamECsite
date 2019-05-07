package com.internousdev.venus.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.venus.dao.UserInfoDAO;
import com.internousdev.venus.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {
	public String userId;
	public String familyName;
	public String firstName;
	public String familyNameKana;
	public String firstNameKana;
	public String sex;
	public String email;
	public Map<String, Object> session;

	public String execute() throws SQLException {
		//sessionがタイムアウトのチェック
		if (session.isEmpty()) {
			return "sessionTimeout";
		}
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();

		userInfoDTO = userInfoDAO.getUserId(String.valueOf(session.get("userId")));

		userId = userInfoDTO.getUserId();
		familyName = userInfoDTO.getFamilyName();
		firstName = userInfoDTO.getFirstName();
		familyNameKana = userInfoDTO.getFamilyNameKana();
		firstNameKana = userInfoDTO.getFirstNameKana();
		sex = userInfoDTO.getSex();
		email = userInfoDTO.getEmail();

		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.getUserId();
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamiryNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
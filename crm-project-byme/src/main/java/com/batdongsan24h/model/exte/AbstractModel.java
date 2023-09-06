package com.batdongsan24h.model.exte;

public class AbstractModel {
	private Integer id;
	private String createdBy;
	private java.sql.Timestamp createdDate;
	private String modifiedBy;
	private java.sql.Timestamp modifiedDate;
	private String alert;
	private String message;
	private String type;
	private Integer[] ids;
	private String validate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public java.sql.Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.sql.Timestamp timestamp) {
		this.createdDate = timestamp;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public java.sql.Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.sql.Timestamp timestamp) {
		this.modifiedDate = timestamp;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}
	
}

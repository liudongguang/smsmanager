package com.peony.api.vo;

public class MsgRS {
	private String version;
	private boolean error;
	private String code;
	private String message;
	private String id;
	private String count;
	private String success;
	private String fail;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFail() {
		return fail;
	}

	public void setFail(String fail) {
		this.fail = fail;
	}

	@Override
	public String toString() {
		return "MsgRS [version=" + version + ", error=" + error + ", code=" + code + ", message=" + message + ", id="
				+ id + ", count=" + count + ", success=" + success + ", fail=" + fail + "]";
	}
	
}

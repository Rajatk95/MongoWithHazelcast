package com.architecture.prod.model;

public class TenantMap {
	String tenantId;
	String dbName;

	public TenantMap() {
	}

	public TenantMap(final String tenantId, final String dbName) {
		this.tenantId = tenantId;
		this.dbName = dbName;
	}

	public TenantMap(final String dbName) {
		this.dbName = dbName;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(final String tenantId) {
		this.tenantId = tenantId;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(final String dbName) {
		this.dbName = dbName;
	}
}
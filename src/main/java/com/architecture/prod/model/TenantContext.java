package com.architecture.prod.model;

public final class TenantContext {
	
	private static String context = "default";

	public static final String getContext() {
		return context;
	}

	public static final void setContext(String context) {
		TenantContext.context = context;
	}
}

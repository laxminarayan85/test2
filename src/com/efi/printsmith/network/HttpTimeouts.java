package com.efi.printsmith.network;

public class HttpTimeouts {
	public static HttpTimeouts DEFAULT_TIMEOUTS = new HttpTimeouts(
			Long
					.getLong("com.printcafe.common.network.readTimeout.default",
							30 * 1000).longValue(), 
			Long
				.getLong("com.printcafe.common.network.connectTimeout.default",
							3600 * 1000).longValue());

	public static HttpTimeouts NO_TIMEOUTS = new HttpTimeouts(0, 0);

	public HttpTimeouts(long readMillis, long connectMillis) {
		this.readMillis = readMillis;
		this.connectMillis = connectMillis;
	}

	public long getReadTimeoutMillis() {
		return this.readMillis;
	}

	public long getConnectTimeoutMillis() {
		return this.connectMillis;
	}

	private long readMillis = 0;

	private long connectMillis = 0;
}

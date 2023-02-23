package com.personal.consul_examples;

import java.util.Date;

public class HealthCheck {
String active_cluster;
	
	Date hc_time;

	public Date getHc_time() {
		return hc_time;
	}

	public void setHc_time(Date hc_time) {
		this.hc_time = hc_time;
	}

	public String getActive_cluster() {
		return active_cluster;
	}

	public void setActive_cluster(String active_cluster) {
		this.active_cluster = active_cluster;
	}

}

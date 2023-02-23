package com.personal.consul_examples;

public class IPLookupModel {
String ip;
String dnsquery;

public String getDnsquery() {
	return dnsquery;
}
public void setDnsquery(String dnsquery) {
	this.dnsquery = dnsquery;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public int getFraud_score() {
	return fraud_score;
}
public void setFraud_score(int fraud_score) {
	this.fraud_score = fraud_score;
}
int fraud_score;
}

package com.personal.consul_examples;

public class DNSRaw {
long ts;
public long getTs() {
	return ts;
}
public void setTs(long ts) {
	this.ts = ts;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public long getOrig() {
	return orig;
}
public void setOrig(long orig) {
	this.orig = orig;
}
public String getResp_host() {
	return resp_host;
}
public void setResp_host(String resp_host) {
	this.resp_host = resp_host;
}
public String getProto() {
	return proto;
}
public void setProto(String proto) {
	this.proto = proto;
}
public long getTrans_id() {
	return trans_id;
}
public void setTrans_id(long trans_id) {
	this.trans_id = trans_id;
}

public int getQclass() {
	return qclass;
}
public void setQclass(int qclass) {
	this.qclass = qclass;
}
public String getQclass_name() {
	return qclass_name;
}
public void setQclass_name(String qclass_name) {
	this.qclass_name = qclass_name;
}
public int getQtype() {
	return qtype;
}
public void setQtype(int qtype) {
	this.qtype = qtype;
}
public String getQtype_name() {
	return qtype_name;
}
public void setQtype_name(String qtype_name) {
	this.qtype_name = qtype_name;
}
public int getRcode() {
	return rcode;
}
public void setRcode(int rcode) {
	this.rcode = rcode;
}
public String getRcode_name() {
	return rcode_name;
}
public void setRcode_name(String rcode_name) {
	this.rcode_name = rcode_name;
}
public boolean isAA() {
	return AA;
}
public void setAA(boolean aA) {
	AA = aA;
}
public boolean isTC() {
	return TC;
}
public void setTC(boolean tC) {
	TC = tC;
}
public boolean isRD() {
	return RD;
}
public void setRD(boolean rD) {
	RD = rD;
}
public boolean isRA() {
	return RA;
}
public void setRA(boolean rA) {
	RA = rA;
}
public int getZ() {
	return Z;
}
public void setZ(int z) {
	Z = z;
}
public boolean isRejected() {
	return rejected;
}
public void setRejected(boolean rejected) {
	this.rejected = rejected;
}
String uid;
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public int getRespport() {
	return respport;
}
public void setRespport(int respport) {
	this.respport = respport;
}
public String getDnsquery() {
	return dnsquery;
}
public void setDnsquery(String dnsquery) {
	this.dnsquery = dnsquery;
}
String ip;
long orig;
String resp_host;
int respport;
String proto;
long trans_id;
String dnsquery;
int qclass;
String qclass_name;
int qtype;
String qtype_name;
int rcode;
String rcode_name;
boolean AA;
boolean TC;
boolean RD;
boolean RA;
int Z;
boolean rejected;
}

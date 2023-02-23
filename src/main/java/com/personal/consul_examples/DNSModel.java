package com.personal.consul_examples;

public class DNSModel {
	double ts;
	public double getTs() {
		return ts;
	}
	public void setTs(double ts) {
		this.ts = ts;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public IDModel getId() {
		return id;
	}
	public void setId(IDModel id) {
		this.id = id;
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
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQclass() {
		return qclass;
	}
	public void setQclass(String qclass) {
		this.qclass = qclass;
	}
	public String getQclass_name() {
		return qclass_name;
	}
	public void setQclass_name(String qclass_name) {
		this.qclass_name = qclass_name;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
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
	
	IDModel id;
	String proto;
	long trans_id;
	String query;
	String qclass;
	String qclass_name;
	String qtype;
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

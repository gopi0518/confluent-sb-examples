package com.personal.consul_examples;

public class SplunkEventGen {
String event;
public String getEvent() {
	return event;
}
public void setEvent(String event) {
	this.event = event;
}
public long getTime() {
	return time;
}
public void setTime(long time) {
	this.time = time;
}
public String getHost() {
	return host;
}
public void setHost(String host) {
	this.host = host;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getIndex() {
	return index;
}
public void setIndex(String index) {
	this.index = index;
}
public String getSourcetype() {
	return sourcetype;
}
public void setSourcetype(String sourcetype) {
	this.sourcetype = sourcetype;
}
long time;
String host;
String source;
String index;
String sourcetype;
}

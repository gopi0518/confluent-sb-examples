package com.personal.consul_examples;
import com.ipqualityscore.JavaIPQSDBReader.*;
public class IPDatabase {
	public void getIPDB() {
	try {
	    // Open a DB file reader.
	    FileReader reader = DBReader.Open("IPQualityScore-IP-Reputation-Database-Sample.ipqs");
	    
	    // Request data about a given IP address.
	    String ip = "8.8.0.0";
	    IPQSRecord record = reader.Fetch(ip);

	    // Use the IPQSRecord to print some data about this IP.
	    if(record.isProxy()){
	        System.out.println(ip + " is a proxy.");
	    } else {
	        System.out.println(ip + " is not a proxy.");
	    }
	} catch (Exception e){
	    System.out.println(e.getMessage());
	}
	
	}
}

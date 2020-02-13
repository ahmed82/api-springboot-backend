package com.rbs.backendspringboot.exception;

public class UsernameNotFoundException {
	
	private String mesg;
	
	

	public UsernameNotFoundException() {
		super();
	}

	public UsernameNotFoundException(String mesg) {
		super();
		this.mesg = mesg;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	
	

}

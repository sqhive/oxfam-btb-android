package com.androidaz.scanner;

class DbEntry {
	public Integer identifier;
	public String[] codes;
	
	public DbEntry(Integer id, String[] codes) {
		this.identifier = id;
		this.codes = codes;
	}
}
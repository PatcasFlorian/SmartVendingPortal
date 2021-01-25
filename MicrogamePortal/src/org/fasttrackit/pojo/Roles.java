package org.fasttrackit.pojo;

public enum Roles {
	SUPERADMIN,
	ADMIN,
	USER;
	
	 public  Roles convert(String str) {
	        for (Roles demoType : Roles.values()) {
	            if (demoType.toString().equals(str)) {
	                return demoType;
	            }
	        }
	        return null;
	    }

}

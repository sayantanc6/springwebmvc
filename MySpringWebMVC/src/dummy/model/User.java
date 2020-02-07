package dummy.model;

import java.io.File;

public class User {
	
	private  String username;
	private String password;
	private File convFile;
	
	public User() {
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public File getConvFile() {
		return convFile;
	}

	public void setConvFile(File convFile) {
		this.convFile = convFile;
	}
}

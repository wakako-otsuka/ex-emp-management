package jp.co.sample.domain;

/**
 * 
 * 管理者情報を表すドメイン.
 * 
 * 
 * @auther wakako.otsuka
 * 
 */

public class Administrator {


	private Integer id;
	
	private String name;
	
	private String mailAddress;
	
	private String password;
	
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mail Address=" + mailAddress + ", password=" + password + "]";
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
}

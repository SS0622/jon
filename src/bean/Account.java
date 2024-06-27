package bean;

import java.io.Serializable;

public class Account implements Serializable {
	private String accountId;
	private String password;
	private boolean admin;
	private String accountName;
	private String iconPath;
	private String mail;
	private boolean withdrawal;
	
	// アカウントID
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	// パスワード
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// 管理者権限の有無
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	// アカウントネーム
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	// アイコンの画像パス
	public String getIconPath() {
		return iconPath;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	// メール
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	// アカウントの退会フラグ
	public boolean getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(boolean withdrawal) {
		this.withdrawal = withdrawal;
	}
}

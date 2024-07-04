package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Account;

public class AccountDao extends Dao {
	public boolean checkAccount(string accountId) {
		bool flag = true;
		// コネクションの確立
		Connection connection = getConnection();
		
		PreparedStatement statement = null;
		
		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from ACCOUNT where account_id=?");
			// プリペアードステートメントにアカウントIDをバインド
			statement.setString(1, accountId);
			// プリペアードステートメントを実行
			ResultSet rSet = statement.excuteQuery();
			//アカウントが存在していた場合falseを返す
			if(rSet.next()) {
				flag = false;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return flag;
	}
	
	public Account get(String accountId) throws Exception {
		// accountインスタンスを初期化
		Account account = new Account();
		// コネクションの確立
		Connection connection = getConnection();
		
		PreparedStatement statement = null;
		
		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from ACCOUNT where account_id=?");
			// プリペアードステートメントにアカウントIDをバインド
			statement.setString(1, accountId);
			// プリペアードステートメントを実行
			ResultSet rSet = statement.excuteQuery();
			//アカウントが存在していた場合accountインスタンスにセット
			if (rSet.next()) {
				account.setAccountId(rSet.getString("account_id"));
				account.setPassword(rSet.getString("password"));
				account.setAdmin(rSet.getBoolean("admin"));
				account.setAccountName(rSet.getString("account_name"));
				account.setIconPath(rSet.getString("icon_path"));
				account.setMail(rSet.getString("mail"));
				account.setWithdrawal(rSet.getBoolean("withdrawal")));
			}else {
				account = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return account;
	}
	
	public boolean save(Account account) throws Exception {
		// 既存のアカウントとIDが被っていた場合
		if(checkAccount(account.getAccountId())) {
			return false;
		}
		// コネクションの確立
		Connection connection = getConnection();
		
		PreparedStatement statement = null;
		
		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("insert into ACCOUNT (ACCOUNT_ID, PASSWORD, ADMIN, ACCOUNT_NAME, ICON_PATH, MAIL, WITHDRAWAL) \n"
					+ "values (?, ?, false, ?, ?, ?, false);");
			// プリペアードステートメントにアカウントIDをバインド
			statement.setString(1, account.getAccountId());
			statement.setString(2, account.getAccountPassword());
			statement.setString(3, account.getAccountName());
			statement.setString(4, account.getIconPath());
			statement.setString(5, account.getMail());
			

			// プリペアードステートメントを実行
			ResultSet rSet = statement.excuteQuery();
		} catch (Exception e) {
			throw e;
		} finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		return true;
	}

}

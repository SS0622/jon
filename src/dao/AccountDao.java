package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Account;

public class AccountDao extends Dao {
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
}

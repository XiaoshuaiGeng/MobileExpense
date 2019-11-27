package com.example.project311;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@RequiresApi(api = Build.VERSION_CODES.KITKAT)

public class LoginController {
	private boolean IsUserIDValid;
	private boolean IsUserPasswordValid;

	private boolean access = false;

	public void setAccess(boolean access){
	    this.access = access;
    }

    public boolean getAccess(){
	    return access;
    }

	public boolean VerifyUserID(String UserName) {		//check if User is already exist
		String sql = "select * from Login where Username = ?";
		IsUserIDValid = false;
		try (Connection c = DBUtil.getConn(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, UserName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				IsUserIDValid=true;
			}else {
				System.out.println("Username doesn't exist");
			}
		}catch (SQLException e) {

			e.printStackTrace();
		}
		return IsUserIDValid;
	}
	
	public boolean VerifyUserID(String UserName,String Password) {
		String sql = "select * from Customer where username = ? and password = ?";
        access = false;
		try (Connection c = DBUtil.getConn(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, UserName);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("Welcome!");
                access=true;
			}else {
				System.out.println("Wrong password");
			}
		}catch (SQLException e) {

			e.printStackTrace();
		}
		return access;
	}
}

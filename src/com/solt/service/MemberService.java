package com.solt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.solt.entity.Member;
import com.solt.utility.DatabaseManager;
import com.solt.utility.ShopException;

public class MemberService {

	public Member login(String loginId, String pword) {
		Member member = findMember(loginId);
		if (member==null) {
			throw new ShopException("Please Check LoginID!");
		}
		if (!member.getPassword().equals(pword)) {
			throw new ShopException("Please Check Password!");
		}
		return member;
	}

	private Member findMember(String loginId) {
		String sql = "Select * from member where login_id=?";
		try(Connection con = DatabaseManager.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setLoginId(rs.getString("login_id"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				return member;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Member>findAll(){
		String sql= "Select * from member";
		List<Member>list = new ArrayList<Member>();
		try(Connection con = DatabaseManager.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setLoginId(rs.getString("login_id"));
				member.setName(rs.getString("name"));
				member.setAddress(rs.getString("address"));
				member.setPassword(rs.getString("password"));
				member.setPhone(rs.getString("phone"));
				list.add(member);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

	public void add(Member member) {
		String sql = "insert into member values(?,?,?,?,?);";
		try(Connection con = DatabaseManager.getConnection();
				PreparedStatement stmt  = con.prepareStatement(sql)) {
				stmt.setString(1, member.getLoginId());
				stmt.setString(2, member.getName());
				stmt.setString(3, member.getAddress());
				stmt.setString(4, member.getPassword());
				stmt.setString(5, member.getPhone());
				stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

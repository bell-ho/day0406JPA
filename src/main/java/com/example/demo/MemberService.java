package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao2;
import com.example.demo.entity.Member100;
@Service
public class MemberService implements UserDetailsService {
	@Autowired
	private MemberDao2 dao;

	public void setDao(MemberDao2 dao) {
		this.dao = dao;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		return null;
		Member100 m = dao.findById(username).get();

		if (m == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.builder().username(username).password(m.getPwd())
				.roles(m.getRole()).build();
	}

}

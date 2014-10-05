package org.revo.ser.impl;

import java.util.ArrayList;
import java.util.List;

import org.revo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class userDetailsService implements UserDetailsService {
	@Autowired
	private org.revo.dao.PersonDao PersonDao;

	@Transactional
	
        @Override
	public UserDetails loadUserByUsername(String Email)
			throws UsernameNotFoundException {
		Person Person = PersonDao.GetByEmail(Email);
		if (Person.getType() == -1)
			throw new UsernameNotFoundException("user not found");
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("Role_USER"));
		if (Person.getType() == 0)
			authorities.add(new SimpleGrantedAuthority("Role_ADMIN"));
		return new User(Person.getEmail(), Person.getPassword(), true, true,
				true, true, authorities);
	}

}

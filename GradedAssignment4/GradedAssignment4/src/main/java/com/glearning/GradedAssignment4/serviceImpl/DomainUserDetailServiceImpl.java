package com.glearning.GradedAssignment4.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glearning.GradedAssignment4.entity.DomainUserDetails;
import com.glearning.GradedAssignment4.repository.UserRepository;

@Service
public class DomainUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepository.findByUsername(username).map(DomainUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("invalid username"));

	}

}
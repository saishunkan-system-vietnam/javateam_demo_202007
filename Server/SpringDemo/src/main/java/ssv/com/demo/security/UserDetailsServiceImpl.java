package ssv.com.demo.security;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.val;
import ssv.com.demo.service.UserService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		val otpUser = userService.findByEmail(email);
		if (!otpUser.isPresent()) {
			new UsernameNotFoundException(String.format("User %s was not found : ", email));
		}
		return modelMapper.map(otpUser.get(), JwtUser.class);
	}

}

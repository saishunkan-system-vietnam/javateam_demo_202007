package ssv.com.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;
import ssv.com.demo.controller.dto.UserDTO;
import ssv.com.demo.controller.form.UserForm;
import ssv.com.demo.model.User;
import ssv.com.demo.security.JwtTokenProvider;
import ssv.com.demo.security.JwtUser;
import ssv.com.demo.service.UserService;
import ssv.com.demo.util.JsonResult;

@RestController
@RequestMapping(path = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController extends AbstractRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@GetMapping("/findById/{userId}")
	public JsonResult<UserDTO> findById(@PathVariable Long userId) {
		val user = userService.findById(userId);
		return JsonResult.success(modelMapper.map(user, UserDTO.class));
	}

	@GetMapping("/findAll")
	public JsonResult<List<UserDTO>> findAll() {
		val users = userService.findAll().stream().map(user -> {
			return modelMapper.map(user, UserDTO.class);
		}).collect(Collectors.toList());
		return JsonResult.success(users);
	}

	@PostMapping("/register")
	public JsonResult<UserDTO> register(@RequestBody UserForm userForm) {
		userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
		val user = modelMapper.map(userForm, User.class);
		userService.save(user);
		return JsonResult.success(modelMapper.map(user, UserDTO.class));
	}

	@PostMapping("/login")
	public JsonResult<JwtUser> login(@RequestBody UserForm userForm) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userForm.getEmail(), userForm.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			val jwtUser = (JwtUser) authentication.getPrincipal();
			String tokenAcess = tokenProvider.generateToken(jwtUser);
			jwtUser.setTokenAccess(tokenAcess);
			return JsonResult.success(jwtUser);
		} catch (AuthenticationException exception) {
			SecurityContextHolder.getContext().setAuthentication(null);
			return JsonResult.fail("Email or password invalid", new JwtUser());
		}
	}
}

package ssv.com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssv.com.demo.model.User;
import ssv.com.demo.repository.UserRepository;

@Service
public class UserService extends BaseTransactionalService {

	@Autowired
	private UserRepository userRepository;

	public Long save(User user) {
		return userRepository.save(user);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findById(Long id) {
		return userRepository.findById(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
}

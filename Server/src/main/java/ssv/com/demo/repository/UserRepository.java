package ssv.com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssv.com.demo.exception.DataNotFoundException;
import ssv.com.demo.model.User;
import ssv.com.demo.model.mapper.UserMapper;

@Repository
public class UserRepository {

	@Autowired
	private UserMapper userMapper;

	public Long save(User user) {
		return userMapper.save(user);
	}

	public Optional<User> findByEmail(String email) {
		return userMapper.findByEmail(email);
	}

	public User findById(Long id) {
		return userMapper.findById(id)
				.orElseThrow(() -> new DataNotFoundException(String.format("Not found userId = %d", id)));
	}

	public List<User> findAll() {
		return userMapper.findAll();
	}
}

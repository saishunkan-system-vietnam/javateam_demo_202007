package ssv.com.demo.model.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import ssv.com.demo.model.User;

@Mapper
public interface UserMapper {

	public Long save(User user);

	public Optional<User> findByEmail(String email);

	public Optional<User> findById(Long id);

	public List<User> findAll();
}

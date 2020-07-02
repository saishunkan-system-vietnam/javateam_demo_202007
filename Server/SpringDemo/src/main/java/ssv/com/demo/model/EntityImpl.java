package ssv.com.demo.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityImpl {
	private LocalDateTime createdDate = LocalDateTime.now();
	private String createdUser = "SYSTEM";
	private LocalDateTime updatedDate = LocalDateTime.now();
	private String updatedUser = "SYSTEM";
}

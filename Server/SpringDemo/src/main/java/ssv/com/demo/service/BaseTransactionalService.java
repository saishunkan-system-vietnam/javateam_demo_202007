package ssv.com.demo.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional(noRollbackFor = Throwable.class)
public class BaseTransactionalService {

}

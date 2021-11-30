package ws.synospis.trainingpercyquezada.repository;

import java.util.List;

import ws.synospis.trainingpercyquezada.exception.TrainingException;
import ws.synospis.trainingpercyquezada.model.User;

public interface UserRepository {
	boolean add(User user);
	boolean update(User user) throws TrainingException;
	boolean remove(Long userId);
	User getUser(Long userId) throws TrainingException;
	List<User> list();
}

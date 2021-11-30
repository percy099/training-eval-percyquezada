package ws.synospis.trainingpercyquezada.service;

import java.util.List;

import ws.synospis.trainingpercyquezada.bean.request.UserRequest;
import ws.synospis.trainingpercyquezada.exception.TrainingException;
import ws.synospis.trainingpercyquezada.model.User;

public interface UserService {
	boolean add(UserRequest userReq);
	boolean update(UserRequest userReq, String userId) throws TrainingException;
	User getUser(String userId) throws TrainingException;
	boolean remove(String userId);
	List<User> list();
}

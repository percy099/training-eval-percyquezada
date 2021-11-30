package ws.synospis.trainingpercyquezada.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ws.synospis.trainingpercyquezada.bean.request.UserRequest;
import ws.synospis.trainingpercyquezada.exception.TrainingException;
import ws.synospis.trainingpercyquezada.model.User;
import ws.synospis.trainingpercyquezada.repository.UserRepository;
import ws.synospis.trainingpercyquezada.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Override
	public boolean add(UserRequest userReq) {
		return this.userRepository.add(User.builder().names(userReq.getNames()).lastName(userReq.getLastName()).phone(userReq.getPhone()).password(userReq.getPassword()).build());
	}
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return userRepository.list();
	}
	@Override
	public boolean update(UserRequest userReq,String userId) throws TrainingException {
		return userRepository.update(User.builder().id(Long.parseLong(userId)).names(userReq.getNames()).lastName(userReq.getLastName()).phone(userReq.getPhone()).password(userReq.getPassword()).build());
		
	}
	@Override
	public User getUser(String userId) throws TrainingException {
		// TODO Auto-generated method stub
		return userRepository.getUser(Long.parseLong(userId));
	}
	@Override
	public boolean remove(String userId) {
		// TODO Auto-generated method stub
		return this.userRepository.remove(Long.parseLong(userId));
	}

}

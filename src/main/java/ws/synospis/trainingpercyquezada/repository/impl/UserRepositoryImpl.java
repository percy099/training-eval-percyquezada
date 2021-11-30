package ws.synospis.trainingpercyquezada.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import ws.synospis.trainingpercyquezada.exception.TrainingException;
import ws.synospis.trainingpercyquezada.model.User;
import ws.synospis.trainingpercyquezada.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private static final Map<Long, User> USERS = new HashMap<Long, User>();
	private static Long id = 1L;
	
	
	@Override
	public boolean add(User user) {
		List<User> users = USERS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
		for(User userFor:users) {
			if(userFor.getPhone().equals(user.getPhone())) return false;
		}
		user.setId(id);
		USERS.put(id++, user);
		return true;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return USERS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
	}

	@Override
	public boolean update(User user) throws TrainingException {
		User userToChange = USERS.get(user.getId());
		if (userToChange==null) return false;
		List<User> users = USERS.entrySet().stream().map(k -> k.getValue()).collect(Collectors.toList());
		for(User userFor:users) {
			if(userFor.getPhone().equals(user.getPhone())) throw new TrainingException("El celular ingresado ya existe en la BD");
		}
		userToChange.setNames(user.getNames());
		userToChange.setLastName(user.getLastName());
		userToChange.setPhone(user.getPhone());
		userToChange.setPassword(user.getPassword());
		return true;
	}

	@Override
	public User getUser(Long userId) throws TrainingException{
		// TODO Auto-generated method stub
		User userToGet = USERS.get(userId);
		if (userToGet==null) throw new TrainingException("El Id ingresado no existe en la BD");
		return USERS.get(userId);
	}

	@Override
	public boolean remove(Long userId) {
		// TODO Auto-generated method stub
		User userToDelete = USERS.get(userId);
		if(userToDelete==null) return false;
		USERS.remove(userId);
		return true;
	}

}

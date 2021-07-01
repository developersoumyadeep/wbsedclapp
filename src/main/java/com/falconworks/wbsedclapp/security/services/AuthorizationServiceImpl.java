package com.falconworks.wbsedclapp.security.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.falconworks.wbsedclapp.admin.repositories.UserRepository;
import com.falconworks.wbsedclapp.admin.entities.Employee;
import com.falconworks.wbsedclapp.admin.entities.User;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	private final UserRepository userRepository;

	@Autowired
	public AuthorizationServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean hasPermission(String officeCode, String username) {
		User user = userRepository.findByUsername(username);
		String divCode = officeCode.substring(0,4);
		if (!(user instanceof Employee)) {
			return false;
		} else 
		{
			Employee emp = (Employee)user;
			return emp.getOffice().getOfficeCode().substring(0, 4).equals(divCode);
		}
	}
}

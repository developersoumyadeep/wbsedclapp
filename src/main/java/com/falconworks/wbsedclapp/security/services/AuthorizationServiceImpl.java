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
	public boolean hasPermission(String officeCode, String username, Authorization authorization) {
		User user = userRepository.findByUsername(username);
		if (!(user instanceof Employee)) {
			return false;
		} else {
			Employee emp = (Employee)user;
			if (emp.getAuthorizations().contains(Authorization.SUPERUSER)) {
				return true;
			} else {
				boolean employeeIsAttachedToDivisionOffice = emp.getOffice().getOfficeCode().endsWith("000");
				if (employeeIsAttachedToDivisionOffice) {
					String divCode = officeCode.substring(0,4);
					return emp.getOffice().getOfficeCode().substring(0, 4).equals(divCode) && emp.getAuthorizations().contains(authorization);
				} else {
					return emp.getOffice().getOfficeCode().equals(officeCode) && emp.getAuthorizations().contains(authorization);
				}
			}
		}
	}

	@Override
	public boolean hasPermission(String username, Authorization authorization) {
		User user = userRepository.findByUsername(username);
		if (!(user instanceof Employee)) {
			return false;
		} else
		{
			Employee emp = (Employee)user;
			return emp.getAuthorizations().contains(authorization);
		}
	}
}

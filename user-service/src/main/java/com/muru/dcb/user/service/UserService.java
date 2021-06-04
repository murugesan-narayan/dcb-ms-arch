package com.muru.dcb.user.service;

import com.muru.dcb.user.model.User;
import com.muru.dcb.user.respository.UserRepository;
import com.muru.dcb.user.vo.Department;
import com.muru.dcb.user.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private UserRepository userRepository;
    private RestTemplate restTemplate;
    @Autowired
    public UserService(UserRepository repository, RestTemplate restTemplate){
        this.userRepository = repository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        ResponseTemplateVO vo = new ResponseTemplateVO(department, user);
        return vo;
    }
}

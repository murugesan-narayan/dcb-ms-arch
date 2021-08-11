package com.muru.dcb.user.service;

import com.muru.dcb.user.model.User;
import com.muru.dcb.user.respository.UserRepository;
import com.muru.dcb.user.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
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
        ResponseEntity<Map<String, Object>> entity = restTemplate.exchange(
                "http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                HttpMethod.GET, null,
                new ParameterizedTypeReference<Map<String, Object>>() {
                });
        Map<String, Object> department = entity.getBody();
        return new ResponseTemplateVO(department, user);
    }
}

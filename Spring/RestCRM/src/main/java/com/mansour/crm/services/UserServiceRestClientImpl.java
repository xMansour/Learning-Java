package com.mansour.crm.services;

import com.mansour.crm.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceRestClientImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${crm.rest.url}")
    private String crmRestUrl;

    @Override
    public List<User> getUsers() {
        return restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        }).getBody();
    }

    @Override
    public void addUser(User user) {
        if (user.getId() == 0)
            restTemplate.postForEntity(crmRestUrl, user, String.class);
        else
            restTemplate.put(crmRestUrl, user);
    }

    @Override
    public User getUser(int userId) {
        return restTemplate.getForObject(crmRestUrl + "/" + userId, User.class);
    }

    @Override
    public void deleteUser(int userId) {
        restTemplate.delete(crmRestUrl + "/" + userId);
    }
}

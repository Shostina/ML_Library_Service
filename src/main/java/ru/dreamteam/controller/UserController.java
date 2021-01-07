package ru.dreamteam.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.dreamteam.db.tables.User;
import ru.dreamteam.request.AuthReq;
import ru.dreamteam.response.AuthResp;
import ru.dreamteam.response.GetUsersResp;
import ru.dreamteam.service.UserManagementService;

import java.util.List;

@RestController
public class UserController {
    UserManagementService userManagementService = new UserManagementService();

    @RequestMapping(value = "/auth", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AuthResp auth(@RequestBody AuthReq req) {
        User user = userManagementService.auth(req.getName(), req.getPassword());
        return new AuthResp(user.getUserId());
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AuthResp addUser(@RequestBody AuthReq req) {
        User user = userManagementService.addUser(req.getName(), req.getPassword());
        return new AuthResp(user.getUserId());
    }

    @RequestMapping(value = "/get_all_user", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GetUsersResp getAllUsers() {
        List<User> users = userManagementService.getAllUsers();
        return new GetUsersResp(users);
    }
}

package ru.dreamteam.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.dreamteam.db.tables.User;

import java.util.List;

@Data
@AllArgsConstructor
public class GetUsersResp {
    List<User>users;
}

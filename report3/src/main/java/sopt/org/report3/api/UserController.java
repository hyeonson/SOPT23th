package sopt.org.report3.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sopt.org.report3.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    private final static List<User> userList = new LinkedList<>();

    @GetMapping("")
    public String getTime(){
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dayTime.format(new Date(time));
    }

    @GetMapping("/users/")
    public String getUserList(){
        if(userList.isEmpty())
            return "없습니다";
        String str = new String();
        for(User u : userList)
        {
            str += u.toString();
        }
        return str;
    }
    @GetMapping("/users")
    public String getName(@RequestParam(value = "name", defaultValue = "") final String name){
        List<User> tempList = new LinkedList<>();
        for(User u : userList)
        {
            if(u.getName().equals(name))
                tempList.add(u);
        }
        if(tempList.isEmpty())
            return "없습니다";
        String str = new String();
        for(User u : tempList)
        {
            str += u.toString();
        }
        return str;
    }
    public String getPart(@RequestParam(value = "part", defaultValue = "") final String part){
        List<User> tempList = new LinkedList<>();
        for(User u : userList)
        {
            if(u.getName().equals(part))
                tempList.add(u);
        }
        if(tempList.isEmpty())
            return "없습니다";
        String str = new String();
        for(User u : tempList)
        {
            str += u.toString();
        }
        return str;
    }
    @GetMapping("/users/{user_idx}")
    public String getUserIdx(@PathVariable(value = "user_idx") final int user_idx){
        for(User u : userList)
        {
            if(u.getUser_idx() == user_idx)
                return u.toString();
        }
        return "없습니다";
    }

    @PostMapping("/users")
    public void postUser(@RequestBody final User user){
        userList.add(user);
    }

}

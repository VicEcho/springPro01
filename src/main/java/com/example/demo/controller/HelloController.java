package com.example.demo.controller;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "/hello")
    public String index() {
        return "小妹妹，我会对你负责的";
    }

    @GetMapping("/")
    public String say() {
          return "要优雅，不要污";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users =  userRepository.findAll();
        return users;
    }
//    // 练习builder（）
//    @GetMapping(value = "/role")
//    public RoleDto getRole() {
//        return RoleDto.builder().id(1L).name("vic").build();
//    }「

    // 查询所有角色
    @GetMapping(value="roles")
    public List<Role> getRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    // 根据名称查询
    @GetMapping(value="role")
    public Role getRoleByName(String name) {
        System.out.println("name" + " " + name);
        return roleRepository.findByName(name);
    }

    //新增用户
    @PostMapping(value="user")
    public User addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        System.out.println("user" + " " + user);
        if (bindingResult.hasErrors()) {
            String erroMessage = bindingResult.getFieldError().getDefaultMessage();
            System.out.println(erroMessage);
            return null;
        }
        return userRepository.save(user);
    }
    //删除用户
    @DeleteMapping(value="user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        System.out.println("id" + " " + id);
        try {
            Optional<User> user = userRepository.findById(id);
            User singleUser = user.get();
            System.out.println("singleUser" + singleUser);
            if (singleUser == null) {
                return "该用户不存在";
            }
            userRepository.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    //修改用户
    @PutMapping(value="user/{id}")
    public String updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        System.out.println("user" + " " + user);
        System.out.println("id" + " " + id);
        try {
            Optional<User> oneUser = userRepository.findById(id);
            User singleUser = oneUser.get();
            System.out.println("singleUser" + singleUser);
            if (singleUser == null) {
                return "该用户不存在";
            }
            singleUser.setName(user.getName());
            singleUser.setCode(user.getCode());

            userRepository.save(singleUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    /**
     * url ： user/{id}
     * body：
     * {
     *     name: 'vic',
     *     code: '123'
     * }
     *
     * url：user/{id}
     * body
     *  {
     *     id: 1,
     *     name: 'vic',
     *     code: '123'
     *  }
     *
     * url： user
     * body {
     *    id: 1
     *    name: 'vic',
     *    code: '123'
     * }
     *
     *
     *
     *
     * */
}


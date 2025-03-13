package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.dao.RoleRepositoryImp;
import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepositoryImp roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    public List<Role> findRolesById(List<Long> id) {
        return roleRepository.findRolesById(id);
    }

    @Transactional
    public void saveRole(Role role) {
        roleRepository.saveRole(role);
    }
}

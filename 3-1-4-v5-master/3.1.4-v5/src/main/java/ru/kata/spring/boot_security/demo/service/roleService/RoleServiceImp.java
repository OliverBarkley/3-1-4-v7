package ru.kata.spring.boot_security.demo.service.roleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Set<Role> findRoles(List<Long> roles) {
        return roleDao.findRoles(roles);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
    @Transactional
    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return  roleDao.getRoleById(id);
    }
}

package edu.uni.pe.medicprojectback.service.Interface;

import edu.uni.pe.medicprojectback.model.Usuario;

public interface UserService {
    Usuario createUser(Usuario user);
    Usuario updateUser(Long id, Usuario user);
    void deleteUser(Long id);
}

package edu.uni.pe.medicprojectback.service.Impl;

import edu.uni.pe.medicprojectback.model.Usuario;
import edu.uni.pe.medicprojectback.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Usuario createUser(Usuario user) {
        String sql = "insert into usuario (id_cod_uni,contraseña ,nro_contacto , correo,rol,estado,reserva ) values (?,?,?,?,'CLI','REG',false)";
        jdbcTemplate.update(sql, user.getIdCodUni(),user.getContraseña(),user.getNroContacto(),user.getCorreo());
        return user;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public Usuario updateUser(Long id, Usuario user) {
        StringBuilder sql = new StringBuilder("UPDATE usuario SET ");
        List<Object> params = new ArrayList<>();

        if (user.getContraseña() != null && !user.getContraseña().isEmpty()) {
            sql.append("contraseña = ?, ");
            params.add(user.getContraseña());
        }

        if (user.getNroContacto() != 0) {
            sql.append("nro_contacto = ?, ");
            params.add(user.getNroContacto());
        }

        if (user.getCorreo() != null && !user.getCorreo().isEmpty()) {
            sql.append("correo = ?, ");
            params.add(user.getCorreo());
        }

        // Remove the last comma and space
        if (params.isEmpty()) {
            // No fields to update
            return user;
        }

        sql.setLength(sql.length() - 2);
        sql.append(" WHERE id_cod_uni = ?");
        params.add(id);

        jdbcTemplate.update(sql.toString(), params.toArray());
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        String sql = "DELETE FROM Usuario WHERE id_cod_uni = ?";
        jdbcTemplate.update(sql, id);
    }

}

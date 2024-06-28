package edu.uni.pe.medicprojectback.service.Impl;

import edu.uni.pe.medicprojectback.model.BaseDatosTest;
import edu.uni.pe.medicprojectback.service.Interface.BancoDatosTestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BancoDatosTestImpl implements BancoDatosTestService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public BaseDatosTest crearBaseDatosTest(BaseDatosTest baseDatosTest) {
        String sql = "INSERT INTO base_datos_test (version_test, fecha_test, nombre, descripcion, id_web) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, baseDatosTest.getVersionTest(), baseDatosTest.getFechaTest(), baseDatosTest.getNombre(), baseDatosTest.getDescripcion(), baseDatosTest.getIdWeb());
        // Asignar el id generado automáticamente
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        baseDatosTest.setIdTest(id);
        return baseDatosTest;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public BaseDatosTest actualizarBaseDatosTest(int id, BaseDatosTest baseDatosTest) {
        String sql = "UPDATE base_datos_test SET version_test = ?, fecha_test = ?, nombre = ?, descripcion = ?, id_web = ? WHERE id_test = ?";
        jdbcTemplate.update(sql, baseDatosTest.getVersionTest(), baseDatosTest.getFechaTest(), baseDatosTest.getNombre(), baseDatosTest.getDescripcion(), baseDatosTest.getIdWeb(), id);
        baseDatosTest.setIdTest(id);
        return baseDatosTest;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void eliminarBaseDatosTest(int id) {
        String sql = "DELETE FROM base_datos_test WHERE id_test = ?";
        jdbcTemplate.update(sql, id);
    }
}

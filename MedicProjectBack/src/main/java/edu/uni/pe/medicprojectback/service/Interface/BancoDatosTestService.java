package edu.uni.pe.medicprojectback.service.Interface;

import edu.uni.pe.medicprojectback.model.BaseDatosTest;

public interface BancoDatosTestService {
    BaseDatosTest crearBaseDatosTest(BaseDatosTest baseDatosTest);
    BaseDatosTest actualizarBaseDatosTest(int id, BaseDatosTest baseDatosTest);
    void eliminarBaseDatosTest(int id);
}

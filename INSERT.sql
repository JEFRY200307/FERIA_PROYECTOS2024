INSERT INTO Usuario (id_cod_uni, contraseña, nro_contacto, correo, rol, estado, reserva)
VALUES ('ABC123456', 'password', 123456789, 'usuario1@example.com', 'CLI', 'REG', false),
       ('DEF987654', 'pass1234', 987654321, 'usuario2@example.com', 'ADM', 'NAP', false),
       ('GHI246813', 'abcd4321', 246813579, 'usuario3@example.com', 'MED', 'NAP', false);


INSERT INTO HistorialWeb (id_web,version_web, fecha_creacion, descripcion, id_cod_uni)
VALUES (1,'1.0.0', '2024-06-28', 'Primera versión del sitio web', 'ABC123456');


INSERT INTO BaseDatosTest (id_test,version_test, fecha_test, nombre, descripcion, id_web)
VALUES (1,'1.0.0', '2024-06-30', 'Test de rendimiento', 'Evaluar la carga máxima del servidor', 1),
       (2,'1.0.0', '2024-07-10', 'Test de seguridad', 'Identificar vulnerabilidades en el sistema', 1),
       (3,'1.0.0', '2024-08-20', 'Test de usabilidad', 'Evaluar la experiencia del usuario', 1);


INSERT INTO BancoDePreguntas (id_preg,tipo_preg, fecha_creacion, descripcion)
VALUES (1,'Selección múltiple', '2024-06-25', 'Preguntas para examen de certificación'),
       (2,'Verdadero/Falso', '2024-07-05', 'Preguntas de repaso para el curso'),
       (3,'Respuesta corta', '2024-08-10', 'Preguntas de evaluación continua');

INSERT INTO TestPregunta (id_test, id_preg, peso, fecha_creacion)
VALUES (1, 1, 5, '2024-06-30'),
       (1, 2, 3, '2024-07-15'),
       (1, 3, 4, '2024-08-25');

INSERT INTO Organizacion (nombre, encargado_org, habilitado, id_web)
VALUES ('CEM', 'Juan Pérez', true, 1),
       ('CEM', 'María Gómez', true, 1),
       ('CEM', 'Luis Martínez', true, 1);

INSERT INTO Cita (id_cita, fecha, hora_inicio, hora_fin, estado, departamento, nombre_especialista, apellido_especialista, id_cod_uni, id_org)
VALUES (1, '2024-07-01', '09:00:00', '10:00:00', 'ACT', 'PSI', 'Dr. López', 'Martínez', 'ABC123456', 1),
       (2, '2024-07-05', '14:00:00', '15:00:00', 'RES', 'PQT', 'Dra. González', 'Pérez', 'DEF987654', 1),
       (3, '2024-07-10', '11:30:00', '12:30:00', 'FAL', 'PSI', 'Dr. Sánchez', 'Gómez', 'GHI246813', 1);

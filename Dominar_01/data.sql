create database dominar_db;
use dominar_db;

select * from User;
select * from book;

INSERT INTO book (id_book, titulo, autor, precio) VALUES
  (1, 'El Resplandor', 'Bram Stoker', 26.84),
  (2, '1984', 'George Orwell', 18.03),
  (3, 'Drácula', 'Leo Tolstoy', 20.23),
  (4, 'Crimen y Castigo', 'Bram Stoker', 38.45),
  (5, 'Guerra y Paz', 'Virginia Woolf', 27.62),
  (6, 'Cumbres Borrascosas', 'Roald Dahl', 35.61),
  (7, 'Guerra y Paz', 'Oscar Wilde', 25.68),
  (8, 'El Retrato de Dorian Gray', 'Mary Shelley', 28.54),
  (9, 'Matar a un Ruiseñor', 'Stephen King', 15.96),
  (10, 'Don Quijote de la Mancha', 'Jane Austen', 6.69),
  (11, 'El Resplandor', 'Roald Dahl', 41.65),
  (12, 'El Señor de los Anillos', 'Miguel de Cervantes', 7.48),
  (13, 'Un Mundo Feliz', 'Stephen King', 6.44),
  (14, 'Cumbres Borrascosas', 'Aldous Huxley', 40.63),
  (15, 'Frankenstein', 'Mark Twain', 39.78),
  (16, 'El Retrato de Dorian Gray', 'Gabriel García Márquez', 34.59),
  (17, 'Un Mundo Feliz', 'Miguel de Cervantes', 46.36),
  (18, 'Las Aventuras de Sherlock Holmes', 'Virginia Woolf', 41.26),
  (19, 'El Retrato de Dorian Gray', 'George Orwell', 35.62),
  (20, 'La Señora Dalloway', 'H.G. Wells', 26.05),
  (21, 'Crimen y Castigo', 'Miguel de Cervantes', 47.18),
  (22, 'Grandes Esperanzas', 'Ray Bradbury', 9.23),
  (23, 'Cumbres Borrascosas', 'Franz Kafka', 8.56),
  (24, '1984', 'Bram Stoker', 46.35),
  (25, 'Drácula', 'Roald Dahl', 8.17),
  (26, 'Cien Años de Soledad', 'Emily Brontë', 11.49),
  (27, 'Crimen y Castigo', 'Oscar Wilde', 6.0),
  (28, 'Charlie y la Fábrica de Chocolate', 'Herman Melville', 39.56),
  (29, 'El Viejo y el Mar', 'F. Scott Fitzgerald', 19.01),
  (30, 'Don Quijote de la Mancha', 'Franz Kafka', 32.05);
  
  
 INSERT INTO user (id_user, nombre, email, age) VALUES
  (1, 'Juan Pérez', 'juan.perez@email.com', 28),
  (2, 'Ana García', 'ana.garcia@email.com', 32),
  (3, 'Carlos López', 'carlos.lopez@email.com', 45),
  (4, 'María Rodríguez', 'maria.rodriguez@email.com', 26),
  (5, 'Luis Martínez', 'luis.martinez@email.com', 35),
  (6, 'Sofía Hernández', 'sofia.hernandez@email.com', 29),
  (7, 'Diego González', 'diego.gonzalez@email.com', 41),
  (8, 'Laura Sánchez', 'laura.sanchez@email.com', 23),
  (9, 'Miguel Torres', 'miguel.torres@email.com', 38),
  (10, 'Carmen Ruiz', 'carmen.ruiz@email.com', 31),
  (11, 'Pedro Díaz', 'pedro.diaz@email.com', 47),
  (12, 'Elena Morales', 'elena.morales@email.com', 24),
  (13, 'Francisco Vega', 'francisco.vega@email.com', 36),
  (14, 'Isabel Castro', 'isabel.castro@email.com', 30),
  (15, 'Antonio Romero', 'antonio.romero@email.com', 42),
  (16, 'Paula Navarro', 'paula.navarro@email.com', 27),
  (17, 'Roberto Silva', 'roberto.silva@email.com', 39),
  (18, 'Sara Jiménez', 'sara.jimenez@email.com', 33),
  (19, 'Javier Ortiz', 'javier.ortiz@email.com', 44),
  (20, 'Lucía Mendoza', 'lucia.mendoza@email.com', 25),
  (21, 'Andrés Castillo', 'andres.castillo@email.com', 37),
  (22, 'Valeria Ramos', 'valeria.ramos@email.com', 22),
  (23, 'Óscar Flores', 'oscar.flores@email.com', 40),
  (24, 'Nerea Soto', 'nerea.soto@email.com', 34),
  (25, 'Raúl Guerrero', 'raul.guerrero@email.com', 46),
  (26, 'Marta Domínguez', 'marta.dominguez@email.com', 21),
  (27, 'Sergio Molina', 'sergio.molina@email.com', 43),
  (28, 'Clara Vidal', 'clara.vidal@email.com', 29),
  (29, 'David Rubio', 'david.rubio@email.com', 50),
  (30, 'Pilar Serrano', 'pilar.serrano@email.com', 36);
  
  DELIMITER //
CREATE PROCEDURE sp_listarPrimeros_10()
BEGIN
    SELECT * FROM book ORDER BY idbook ASC LIMIT 10;
END //
DELIMITER ;
CALL sp_listarPrimeros_10();

DELIMITER //
CREATE PROCEDURE sp_crear_usuario(IN p_nombre VARCHAR(50), IN p_email VARCHAR(50), IN p_age INT)
BEGIN
    INSERT INTO user (nombre, email, age) VALUES (p_nombre, p_email, p_age);
    SELECT * FROM user WHERE id_user = LAST_INSERT_ID();
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_actualizar_usuario(IN p_id INT, IN p_nombre VARCHAR(50), IN p_email VARCHAR(50), IN p_age INT)
BEGIN
    UPDATE user SET nombre = p_nombre, email = p_email, age = p_age WHERE id_user = p_id;
    SELECT * FROM user WHERE id_user = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_buscarPorIdUsuarios(IN p_id INT)
BEGIN
    SELECT * FROM user WHERE id_user = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_eliminarUsuario(IN p_id INT)
BEGIN
    DELETE FROM user WHERE id_user = p_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_listarTodosUsuarios()
BEGIN
    SELECT * FROM user;
END //
DELIMITER ;


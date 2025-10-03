package com.dominar01.demo.repository.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import com.dominar01.demo.model.User;
import com.dominar01.demo.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setIdUser(rs.getInt("id_user"));
            user.setName(rs.getString("nombre"));
            user.setEmail(rs.getString("email"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    };

    @Override
    public User save(User user) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_crear_usuario")
                .returningResultSet("rs", userRowMapper);

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_nombre", user.getName());
        inParams.put("p_email", user.getEmail());
        inParams.put("p_age", user.getAge());

        Map<String, Object> out = jdbcCall.execute(inParams);
        List<User> users = (List<User>) out.get("rs");
        return users != null && !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public User update(Integer id, User user) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_actualizar_usuario")
                .returningResultSet("rs", userRowMapper);

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_id", id);
        inParams.put("p_nombre", user.getName());
        inParams.put("p_email", user.getEmail());
        inParams.put("p_age", user.getAge());

        Map<String, Object> out = jdbcCall.execute(inParams);
        List<User> users = (List<User>) out.get("rs");
        return users != null && !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public User findById(Integer id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_buscarPorIdUsuarios")
                .returningResultSet("rs", userRowMapper);

        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_id", id);

        Map<String, Object> out = jdbcCall.execute(inParams);
        List<User> users = (List<User>) out.get("rs");
        return users != null && !users.isEmpty() ? users.get(0) : null;
    }

    @Override
    public List<User> findAll() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_listarTodosUsuarios")
                .returningResultSet("rs", userRowMapper);

        Map<String, Object> out = jdbcCall.execute(new HashMap<>());
        return (List<User>) out.get("rs");
    }

    @Override
    public void deleteById(Integer id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("sp_eliminarUsuario")
                .declareParameters(
                        new SqlParameter("p_id", Types.INTEGER) 
                );
        Map<String, Object> inParams = new HashMap<>();
        inParams.put("p_id", id);
        jdbcCall.execute(inParams);
    }

}
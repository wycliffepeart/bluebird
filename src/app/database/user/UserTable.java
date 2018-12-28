package app.database.user;

import support.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTable extends Database<UserEntity> {

    /**
     * The id column name
     *
     * @field ID_COLUMN {@link String}
     */
    private final String ID_NUMBER_COLUMN = "idNumber";

    /**
     * The username column name
     *
     * @field USERNAME_COLUMN {@link String}
     */
    private final String USERNAME_COLUMN = "username";

    /**
     * The role column name
     *
     * @field ROLE_COLUMN {@link String}
     */
    private final String ROLE_COLUMN = "role";

    /**
     * The password column name
     *
     * @field PASSWORD_COLUMN {@link String}
     */
    private final String PASSWORD_COLUMN = "password";

    /**
     * The name of the user table
     */
    private final String TABLE = "users";

    /**
     * The default constructor
     */
    public UserTable() {
        super();

        initialize();
    }

    /**
     * Initialize the user table
     */
    private void initialize() {

        final String statement = String.format("CREATE TABLE IF NOT EXISTS %s(%s,\n%s,\n%s,\n%s)",
                TABLE,
                String.format("%s text PRIMARY KEY", ID_NUMBER_COLUMN),
                String.format("%s text NOT NULL", USERNAME_COLUMN),
                String.format("%s text NOT NULL", ROLE_COLUMN),
                String.format("%s text NOT NULL", PASSWORD_COLUMN)
        );

        try {

            execute(statement);

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }


    /**
     * Retrieve all the models from the database
     *
     * @return {@link List}
     */
    public UserEntity whereIdAndPassword(String idNumber, String password) {

        UserEntity userEntity = new UserEntity();

        try {

            ResultSet resultSet = query(String.format("SELECT * FROM %s WHERE idNumber = '%s' AND password = '%s' LIMIT 1", TABLE, idNumber, password));

            userEntity.setIdNumber(resultSet.getString(ID_NUMBER_COLUMN));
            userEntity.setUsername(resultSet.getString(USERNAME_COLUMN));
            userEntity.setRole(resultSet.getString(ROLE_COLUMN));
            userEntity.setPassword(resultSet.getString(PASSWORD_COLUMN));

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return userEntity;
    }

    /**
     * Retrieve all the models from the database
     *
     * @return {@link List}
     */
    @Override
    public List<UserEntity> query() {

        final List<UserEntity> personModelList = new ArrayList<>();

        try {

            ResultSet resultSet = query(String.format("SELECT * FROM %s", TABLE));

            while (resultSet.next()) {

                UserEntity personModel = new UserEntity();

                personModel.setIdNumber(resultSet.getString(ID_NUMBER_COLUMN));
                personModel.setUsername(resultSet.getString(USERNAME_COLUMN));
                personModel.setRole(resultSet.getString(ROLE_COLUMN));
                personModel.setPassword(resultSet.getString(PASSWORD_COLUMN));

                personModelList.add(personModel);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return personModelList;
    }

    /**
     * Store a given entity in the database
     *
     * @param entity {@link UserEntity}
     * @return {@link List}
     */
    @Override
    public int insert(UserEntity entity) {

        final String sql = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?,?,?,?)",
                TABLE, ID_NUMBER_COLUMN, USERNAME_COLUMN, ROLE_COLUMN, PASSWORD_COLUMN);

        return processUpdate(entity, sql);
    }

    /**
     * Update a given entity in the database
     *
     * @param entity {@link UserEntity}
     * @return {@link List}
     */
    @Override
    public int update(UserEntity entity) {

        final String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE id = ?",
                TABLE, ID_NUMBER_COLUMN, USERNAME_COLUMN, ROLE_COLUMN, PASSWORD_COLUMN);

        return processUpdate(entity, sql);
    }

    /**
     * Process update
     *
     * @param entity {@link UserEntity}
     * @param sql    {@link String}
     */
    private int processUpdate(UserEntity entity, String sql) {

        int success = 0;

        try {

            final PreparedStatement statement = preparedStatement(sql);

            statement.setString(1, entity.getIdNumber());

            statement.setString(2, entity.getUsername());

            statement.setString(3, entity.getRole());

            statement.setString(4, entity.getPassword());

            success = statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

            System.out.println(e.getMessage());
        }

        return success;
    }

    /**
     * Remove the entity with the given id from the database
     *
     * @param entity {@link UserEntity}
     * @return {@link Boolean}
     */
    @Override
    public boolean delete(UserEntity entity) {

        String sql = String.format("DELETE FROM %s WHERE %s = ?", TABLE, ID_NUMBER_COLUMN);

        try {

            final PreparedStatement statement = preparedStatement(sql);
            statement.setString(1, entity.getIdNumber());
            statement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
}

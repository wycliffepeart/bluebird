package app.database.user;


public class UserEntity {

    /**
     * The user id
     *
     * @field id {@link Integer}
     */
    private String idNumber;

    /**
     * The username
     *
     * @field username {@link String}
     */
    private String username;

    /**
     * The user role
     *
     * @field role {@link String}
     */
    private String role;

    /**
     * The user password
     *
     * @field password {@link String}
     */
    private String password;

    /**
     * The default constructor
     */
    public UserEntity(){

        idNumber = "";
        username = "";
        role = "";
        password = "";
    }

    /**
     * The primary constructor
     *
     * @param id {@link Integer}
     * @param role {@link String}
     * @param password {@link String}
     */
    public UserEntity(String id, String username, String role, String password) {
        this.idNumber = id;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    /**
     * Retrieve the user id number
     *
     * @return {@link String}
     */
    public String getIdNumber() {

        return idNumber;
    }

    /**
     * Assign the given user id number
     *
     * @param idNumber {@link String}
     */
    public void setIdNumber(String idNumber) {

        this.idNumber = idNumber;
    }

    /**
     * Retrieve the user name
     *
     * @return {@link String}
     */
    public String getUsername() {

        return username;
    }

    /**
     * Assign a given username
     *
     * @param username {@link String}
     */
    public void setUsername(String username) {

        this.username = username;
    }

    /**
     * Retrieve the user role
     *
     * @return {@link String}
     */
    public String getRole() {

        return role;
    }

    /**
     * Assign user given role
     *
     * @param role {@link String}
     */
    public void setRole(String role) {

        this.role = role;
    }

    /**
     * Retrieve the user password
     *
     * @return {@link String}
     */
    public String getPassword() {

        return password;
    }

    /**
     * Assign user password
     *
     * @param password {@link String}
     */
    public void setPassword(String password) {

        this.password = password;
    }
}

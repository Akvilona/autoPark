/**
 * Создал Андрей Антонов 29.08.2023 6:16
 **/
package library.model;


public class User {
    private Integer id;
    private String name;

    public User(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}

package model.classes;

public class Artworks {
    private int id;
    private String title;
    private String description;
    private String image_path;
    private int user_id;

    public Artworks(int id, String title, String description, String image_path, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_path = image_path;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

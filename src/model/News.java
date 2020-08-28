package model;

public class News {

    private int id;
    private String name;
    private String school;
    private int age;

    public News(int id, String name, String school, int age) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.age = age;
    }
    public News( String name, String school, int age) {
        this.name = name;
        this.school = school;
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

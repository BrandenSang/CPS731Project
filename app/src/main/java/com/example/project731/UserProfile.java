package com.example.project731;

public class UserProfile {
    private String newUser;
    private ShoeProfileForLists shoe;

    //constructors

    public UserProfile(String newUser,ShoeProfileForLists shoe){
        this.newUser = newUser;
        this.shoe = shoe;
    }
    public UserProfile(ShoeProfileForLists shoe){
        this.shoe = shoe;
    }
    public UserProfile(){
    }
    //tostring

    @Override
    public String toString() {
        return "UserProfile{\n" +
                "newUser=" + newUser +
                ",\n shoe=" + shoe +
                '}';
    }

    //getters and setters


    public String getNewUser() {
        return newUser;
    }

    public void setNewUser(String newUser) {
        this.newUser = newUser;
    }

    public ShoeProfileForLists getShoe() {
        return shoe;
    }

    public String getShoeName(){
        return shoe.getShoeName();
    }
    public int getShoePic(){
        return shoe.getShoePic();
    }


    public void setShoe(ShoeProfileForLists shoe) {
        this.shoe = shoe;
    }
}

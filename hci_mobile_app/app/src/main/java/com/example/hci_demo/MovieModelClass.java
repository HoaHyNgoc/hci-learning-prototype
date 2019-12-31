package com.example.hci_demo;

public class MovieModelClass {
    private String nameMoive;
    private String timeMovie;
    private int imageAvatarMovie;

    public MovieModelClass(String nameMoive, String timeMovie, int imageAvatarMovie) {
        this.nameMoive = nameMoive;
        this.timeMovie = timeMovie;
        this.imageAvatarMovie = imageAvatarMovie;
    }

    public String getNameMoive() {
        return nameMoive;
    }

    public void setNameMoive(String nameMoive) {
        this.nameMoive = nameMoive;
    }

    public String getTimeMovie() {
        return timeMovie;
    }

    public void setTimeMovie(String timeMovie) {
        this.timeMovie = timeMovie;
    }

    public int getImageAvatarMovie() {
        return imageAvatarMovie;
    }

    public void setImageAvatarMovie(int imageAvatarMovie) {
        this.imageAvatarMovie = imageAvatarMovie;
    }
}

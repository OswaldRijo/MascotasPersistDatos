package com.oswald.mascotas.pojo;

/**
 * Created by oswal on 23/12/2017.
 */

public class Mascota implements java.io.Serializable {

    private int id;
    private int imgFotoMascota;
    private int imgIconoLike;
    private String cvContadorLikes;
    private String cvNombre;
    private int cvIconoLike;


    public Mascota(int imgFotoMascota, String cvNombre, String cvContadorLikes, int cvIconoLike, int imgIconoLike){
        this.imgFotoMascota    = imgFotoMascota;
        this.imgIconoLike      = imgIconoLike;
        this.cvContadorLikes   = cvContadorLikes;
        this.cvNombre          = cvNombre;
        this.cvIconoLike       = cvIconoLike;

    }

    public Mascota() {

    }

    public int getImgFotoMascota() {
        return imgFotoMascota;
    }

    public void setImgFotoMascota(int imgFotoMascota) {
        this.imgFotoMascota = imgFotoMascota;
    }

    public int getImgIconoLike() {
        return imgIconoLike;
    }

    public void setImgIconoLike(int imgIconoLike) {
        this.imgIconoLike = imgIconoLike;
    }

    public String getCvContadorLikes() {
        return cvContadorLikes;
    }

    public void setCvContadorLikes(String cvContadorLikes) {
        this.cvContadorLikes = cvContadorLikes;
    }

    public String getCvNombre() {
        return cvNombre;
    }

    public void setCvNombre(String cvNombre) {
        this.cvNombre = cvNombre;
    }

    public int getCvIconoLike() {
        return cvIconoLike;
    }

    public void setCvIconoLike(int cvIconoLike) {
        this.cvIconoLike = cvIconoLike;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Mascota){
            Mascota newMascota = (Mascota)obj;

            return newMascota.cvNombre.equals(this.cvNombre);
        }
        return false;
    }

    @Override
    public int hashCode (){
        int result = 11;
        result = result*33+this.cvNombre.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

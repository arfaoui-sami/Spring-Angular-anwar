package com.example.projetanwar.entities;


import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "materiel")
public class Materiel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "micro")
    String micro;

    public Materiel() {

    }

    @Override
    public String toString() {
        return "Materiel{" +
                "id=" + id +
                ", micro='" + micro + '\'' +
                ", module='" + module + '\'' +
                ", carte='" + carte + '\'' +
                ", capteur='" + capteur + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Materiel( String micro, String module, String carte, String capteur) {
        this.id = id;
        this.micro = micro;
        this.module = module;
        this.carte = carte;
        this.capteur = capteur;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMicro() {
        return micro;
    }

    public void setMicro(String micro) {
        this.micro = micro;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCarte() {
        return carte;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public String getCapteur() {
        return capteur;
    }

    public void setCapteur(String capteur) {
        this.capteur = capteur;
    }

    @Column(name = "module")
    String module;
    @Column(name = "carte")
    String carte;
    @Column(name = "capteur")
    String capteur;


}

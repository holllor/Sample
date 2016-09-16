/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.home.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author олег
 */
@Entity
@Table(name = "tovar")
@NamedQueries({
    @NamedQuery(name = "Tovar.findAll", query = "SELECT t FROM Tovar t")})
public class Tovar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 400)
    @Column(name = "nametovar")
    private String nametovar;
    @Column(name = "cenatovar")
    private Long cenatovar;
    @Column(name = "razmer")
    private Integer razmer;
    @JoinColumn(name = "leftmenu_id", referencedColumnName = "id")
    @ManyToOne
    private Leftmenu leftmenuId;

    public Tovar() {
    }

    public Tovar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNametovar() {
        return nametovar;
    }

    public void setNametovar(String nametovar) {
        this.nametovar = nametovar;
    }

    public Long getCenatovar() {
        return cenatovar;
    }

    public void setCenatovar(Long cenatovar) {
        this.cenatovar = cenatovar;
    }

    public Integer getRazmer() {
        return razmer;
    }

    public void setRazmer(Integer razmer) {
        this.razmer = razmer;
    }

    public Leftmenu getLeftmenuId() {
        return leftmenuId;
    }

    public void setLeftmenuId(Leftmenu leftmenuId) {
        this.leftmenuId = leftmenuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tovar)) {
            return false;
        }
        Tovar other = (Tovar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.home.entity.Tovar[ id=" + id + " ]";
    }
    
}

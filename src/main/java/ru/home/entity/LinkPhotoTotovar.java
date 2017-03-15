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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author katy
 */
@Entity
@Table(name = "linkPhotoTotovar")
@NamedQueries({
    @NamedQuery(name = "LinkPhotoTotovar.findAll", query = "SELECT l FROM LinkPhotoTotovar l")})
public class LinkPhotoTotovar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "pathFile")
    private String pathFile;
    @Size(max = 100)
    @Column(name = "nameFile")
    private String nameFile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "glavnoePhoto")
    private boolean glavnoePhoto;
      @JoinColumn(name = "tovar_id", referencedColumnName = "id")
    @ManyToOne
    private Tovar tovarId;

    public LinkPhotoTotovar() {
    }

    public LinkPhotoTotovar(Integer id) {
        this.id = id;
    }

    public LinkPhotoTotovar(Integer id, boolean glavnoePhoto) {
        this.id = id;
        this.glavnoePhoto = glavnoePhoto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public boolean getGlavnoePhoto() {
        return glavnoePhoto;
    }

    public void setGlavnoePhoto(boolean glavnoePhoto) {
        this.glavnoePhoto = glavnoePhoto;
    }

    public Tovar getTovarId() {
        return tovarId;
    }

    public void setTovarId(Tovar tovarId) {
        this.tovarId = tovarId;
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
        if (!(object instanceof LinkPhotoTotovar)) {
            return false;
        }
        LinkPhotoTotovar other = (LinkPhotoTotovar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.home.entity.LinkPhotoTotovar[ id=" + id + " ]";
    }
    
}

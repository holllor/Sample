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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author олег
 */
@Entity
@Table(name = "leftmenueasy")
@NamedQueries({
    @NamedQuery(name = "LeftmenuEasy.findAll", query = "SELECT l FROM LeftmenuEasy l")})
public class LeftmenuEasy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "nameMenu")
    private String nameMenu;
    @Column(name = "parent_id")
    private Integer parentId;
    @Size(max = 250)
    @Column(name = "commentmenu")
    private String commentmenu;
    @Column(name = "isGroup")
    private Boolean isGruop;

    public LeftmenuEasy() {
    }

    public LeftmenuEasy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCommentmenu() {
        return commentmenu;
    }

    public void setCommentmenu(String commentmenu) {
        this.commentmenu = commentmenu;
    }

    public Boolean getIsGruop() {
        return isGruop;
    }

    public void setIsGruop(Boolean isGruop) {
        this.isGruop = isGruop;
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
        if (!(object instanceof LeftmenuEasy)) {
            return false;
        }
        LeftmenuEasy other = (LeftmenuEasy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.home.entity.LeftmenuEasy[ id=" + id + " ]";
    }

}

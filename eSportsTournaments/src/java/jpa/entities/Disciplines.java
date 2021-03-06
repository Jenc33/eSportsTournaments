/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ingjo
 */
@Entity
@Table(name = "DISCIPLINES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplines.findAll", query = "SELECT d FROM Disciplines d")
    , @NamedQuery(name = "Disciplines.findById", query = "SELECT d FROM Disciplines d WHERE d.id = :id")
    , @NamedQuery(name = "Disciplines.findByName", query = "SELECT d FROM Disciplines d WHERE d.name = :name")
    , @NamedQuery(name = "Disciplines.findByDescription", query = "SELECT d FROM Disciplines d WHERE d.description = :description")
    , @NamedQuery(name = "Disciplines.findByNoMembers", query = "SELECT d FROM Disciplines d WHERE d.noMembers = :noMembers")})
public class Disciplines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO_MEMBERS")
    private int noMembers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDisciplina")
    private Collection<Torunaments> torunamentsCollection;

    public Disciplines() {
    }

    public Disciplines(Integer id) {
        this.id = id;
    }

    public Disciplines(Integer id, String name, int noMembers) {
        this.id = id;
        this.name = name;
        this.noMembers = noMembers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoMembers() {
        return noMembers;
    }

    public void setNoMembers(int noMembers) {
        this.noMembers = noMembers;
    }

    @XmlTransient
    public Collection<Torunaments> getTorunamentsCollection() {
        return torunamentsCollection;
    }

    public void setTorunamentsCollection(Collection<Torunaments> torunamentsCollection) {
        this.torunamentsCollection = torunamentsCollection;
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
        if (!(object instanceof Disciplines)) {
            return false;
        }
        Disciplines other = (Disciplines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Disciplines[ id=" + id + " ]";
    }
    
}

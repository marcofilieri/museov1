package it.linksmt.academy.hibernate.core.museo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tipologia")
public class Tipologia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipologia")
    private Long id;

    private String denominazione;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipologia")
    private List<Articolo> articolo;

    public Tipologia() {
    }

    public Tipologia(Long id, String denominazione, List<Articolo> articolo) {
        this.id = id;
        this.denominazione = denominazione;
        this.articolo = articolo;
    }

    public Tipologia(Long id, String denominazione) {
        this.id = id;
        this.denominazione = denominazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public List<Articolo> getArticolo() {
        return articolo;
    }

    public void setArticolo(List<Articolo> articolo) {
        this.articolo = articolo;
    }
}

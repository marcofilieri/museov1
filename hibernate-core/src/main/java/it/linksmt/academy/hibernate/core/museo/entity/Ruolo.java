package it.linksmt.academy.hibernate.core.museo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ruolo")
public class Ruolo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruolo")
    private Long id;

    private String denominazione;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ruolo")
    private List<Utente> utente;

    public Ruolo() {
    }

    public Ruolo(Long id, String denominazione, List<Utente> utente) {
        this.id = id;
        this.denominazione = denominazione;
        this.utente = utente;
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

    public List<Utente> getUtente() {
        return utente;
    }

    public void setUtente(List<Utente> utente) {
        this.utente = utente;
    }
}

package it.linksmt.academy.hibernate.core.museo.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "preferito")
public class Preferito implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_preferito")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Utente.class)
    @JoinColumn(name = "fk_id_utente")
    private Utente utente;

    @ManyToOne(targetEntity = Articolo.class)
    @JoinColumn(name = "fk_id_articolo")
    private Articolo articolo;

    public Preferito() {
    }

    public Preferito(Long id, Utente utente, Articolo articolo) {
        this.id = id;
        this.utente = utente;
        this.articolo = articolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }
}

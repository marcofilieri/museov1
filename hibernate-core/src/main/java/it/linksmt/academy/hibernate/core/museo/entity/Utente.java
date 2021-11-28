package it.linksmt.academy.hibernate.core.museo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utente")
    private Long id;

    private String username, password, nome, cognome;

    @Column(name = "data_nascita")
    private Date dataMascita;

    @Column(name = "data_inserimento")
    private Date dataInserimento;

    @Column(name = "data_modifica")
    private Date dataModifica;

    @Column(name = "id_operatore")
    private Long idOperatore;

    @ManyToOne(targetEntity = Ruolo.class)
    @JoinColumn(name = "fk_id_ruolo")
    private Ruolo ruolo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo")
    private List<Preferito> preferito;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utente")
    private List<Sede> sede;

    public Utente() {
    }

    public Utente(Long id, String username, String password, String nome, String cognome, Date dataMascita, Date dataInserimento, Date dataModifica, Long idOperatore, Ruolo ruolo, List<Sede> sede, List<Preferito> preferito) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.dataMascita = dataMascita;
        this.dataInserimento = dataInserimento;
        this.dataModifica = dataModifica;
        this.idOperatore = idOperatore;
        this.ruolo = ruolo;
        this.sede = sede;
        this.preferito = preferito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataMascita() {
        return dataMascita;
    }

    public void setDataMascita(Date dataMascita) {
        this.dataMascita = dataMascita;
    }

    public Date getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(Date dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public Date getDataModifica() {
        return dataModifica;
    }

    public void setDataModifica(Date dataModifica) {
        this.dataModifica = dataModifica;
    }

    public Long getIdOperatore() {
        return idOperatore;
    }

    public void setIdOperatore(Long idOperatore) {
        this.idOperatore = idOperatore;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public List<Sede> getSede() {
        return sede;
    }

    public void setSede(List<Sede> sede) {
        this.sede = sede;
    }

    public List<Preferito> getPreferito() {
        return preferito;
    }

    public void setPreferito(List<Preferito> preferito) {
        this.preferito = preferito;
    }
}
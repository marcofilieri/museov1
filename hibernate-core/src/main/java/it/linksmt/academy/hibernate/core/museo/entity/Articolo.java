package it.linksmt.academy.hibernate.core.museo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articolo")
public class Articolo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_articolo")
    private Long id;

    private String nome;
    private String descrizione;
    private Boolean magazzino;

    @Column(name = "data_reperto")
    private Date dataReperto;

    @Column(name = "data_inserimento")
    private Date dataInserimento;

    @Column(name = "data_modifica")
    private Date dataModifica;

    @Column(name = "id_operatore")
    private Long idOperatore;

    @ManyToOne(targetEntity = Sede.class)
    @JoinColumn(name = "fk_id_sede")
    private Sede sede;

    @ManyToOne(targetEntity = Tipologia.class)
    @JoinColumn(name = "fk_id_tipologia")
    private Tipologia tipologia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo")
    private List<Immagine> immagine;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo")
    private List<Preferito> preferito;

    public Articolo() {
    }

    public Articolo(Long id, String nome, String descrizione, boolean magazzino, Date dataReperto, Date dataInserimento,
                    Date dataModifica, Long idOperatore, Sede sede, Tipologia tipologia, List<Immagine> immagine, List<Preferito> preferito) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.magazzino = magazzino;
        this.dataReperto = dataReperto;
        this.dataInserimento = dataInserimento;
        this.dataModifica = dataModifica;
        this.idOperatore = idOperatore;
        this.sede = sede;
        this.tipologia = tipologia;
        this.immagine = immagine;
        this.preferito = preferito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Boolean isMagazzino() {
        return magazzino;
    }

    public void setMagazzino(Boolean magazzino) {
        this.magazzino = magazzino;
    }

    public Date getDataReperto() {
        return dataReperto;
    }

    public void setDataReperto(Date dataReperto) {
        this.dataReperto = dataReperto;
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

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    public List<Immagine> getImmagine() {
        return immagine;
    }

    public void setImmagine(List<Immagine> immagine) {
        this.immagine = immagine;
    }

    public List<Preferito> getPreferito() {
        return preferito;
    }

    public void setPreferito(List<Preferito> preferito) {
        this.preferito = preferito;
    }
}

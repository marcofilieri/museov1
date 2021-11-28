package it.linksmt.academy.hibernate.core.museo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sede")
public class Sede implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Long id;

    private String nome;
    private String descrizione;
    @Column(name = "ora_apertura")
    private Time orarioApertura;
    @Column(name = "ora_chiusura")
    private Time orarioChiusura;

    private Float latitudine;
    private Float longitudine;

    @Column(name = "data_inserimento")
    private Date dataInserimento;
    @Column(name = "data_modifica")
    private Date dataModifica;
    @Column(name = "id_operatore")
    private Long idOperatore;

    @ManyToOne(targetEntity = Utente.class)
    @JoinColumn(name = "fk_id_responsabile")
    private Utente utente;

    @ManyToOne(targetEntity = Museo.class)
    @JoinColumn(name = "fk_id_museo")
    private Museo museo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sede")
    private List<Articolo> articolo;

    public Sede() {
    }

    public Sede(Long id, String nome, String descrizione, Time orarioApertura, Time orarioChiusura, float latitudine, float longitudine, Date dataInserimento, Date dataModifica, Long idOperatore, Utente utente, Museo museo, List<Articolo> articolo) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.orarioApertura = orarioApertura;
        this.orarioChiusura = orarioChiusura;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.dataInserimento = dataInserimento;
        this.dataModifica = dataModifica;
        this.idOperatore = idOperatore;
        this.utente = utente;
        this.museo = museo;
        this.articolo = articolo;
    }

    public Sede(Long id, String nome, String descrizione, Time orarioApertura, Time orarioChiusura, float latitudine, float longitudine, Date dataInserimento, Date dataModifica, Long idOperatore, Utente utente, Museo museo) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.orarioApertura = orarioApertura;
        this.orarioChiusura = orarioChiusura;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.dataInserimento = dataInserimento;
        this.dataModifica = dataModifica;
        this.idOperatore = idOperatore;
        this.utente = utente;
        this.museo = museo;
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

    public Time getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(Time orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public Time getOrarioChiusura() {
        return orarioChiusura;
    }

    public void setOrarioChiusura(Time orarioChiusura) {
        this.orarioChiusura = orarioChiusura;
    }

    public Float getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(Float latitudine) {
        this.latitudine = latitudine;
    }

    public Float getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(Float longitudine) {
        this.longitudine = longitudine;
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Museo getMuseo() {
        return museo;
    }

    public void setMuseo(Museo museo) {
        this.museo = museo;
    }

    public List<Articolo> getArticolo() {
        return articolo;
    }

    public void setArticolo(List<Articolo> articolo) {
        this.articolo = articolo;
    }
}

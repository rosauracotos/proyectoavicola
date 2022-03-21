package proyectoavicola.example.proyectoavicola.entidad;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "PARTE_PRODUCCION")
public class ParteProduccion {

    @Id
    @Column(name = "parte_cod")
    private String codigo;

    @Column(name = "parprod_item")
    private String parprodItem;

    @Column(name = "parprod_cant")
    private BigDecimal parprodCant;

    @Column(name = "parprod_precio")
    private BigDecimal parprodPrecio;

    @Column(name = "parprod_total")
    private BigDecimal parprodTotal;

    @Column(name = "cant_equiv")
    private BigDecimal cantEquiv;

    @Column(name = "unimed_cod")
    private String unimedCod;

    @Column(name = "parprod_stock")
    private BigDecimal stock;

    @Column(name = "prod_cod")
    private String prodCod;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getParprodItem() {
        return parprodItem;
    }

    public void setParprodItem(String parprodItem) {
        this.parprodItem = parprodItem;
    }

    public BigDecimal getParprodCant() {
        return parprodCant;
    }

    public void setParprodCant(BigDecimal parprodCant) {
        this.parprodCant = parprodCant;
    }

    public BigDecimal getParprodPrecio() {
        return parprodPrecio;
    }

    public void setParprodPrecio(BigDecimal parprodPrecio) {
        this.parprodPrecio = parprodPrecio;
    }

    public BigDecimal getParprodTotal() {
        return parprodTotal;
    }

    public void setParprodTotal(BigDecimal parprodTotal) {
        this.parprodTotal = parprodTotal;
    }

    public BigDecimal getCantEquiv() {
        return cantEquiv;
    }

    public void setCantEquiv(BigDecimal cantEquiv) {
        this.cantEquiv = cantEquiv;
    }

    public String getUnimedCod() {
        return unimedCod;
    }

    public void setUnimedCod(String unimedCod) {
        this.unimedCod = unimedCod;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getProdCod() {
        return prodCod;
    }

    public void setProdCod(String prodCod) {
        this.prodCod = prodCod;
    }
}

package sv.foodboard.www.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "orden", schema = "foodboard", catalog = "")
public class OrdenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idOrden", nullable = false)
    private int idOrden;
    @Basic
    @Column(name = "codigoClient", nullable = false, length = 8)
    private String codigoClient;
    @Basic
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @Basic
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Timestamp fecha;
    @Basic
    @Column(name = "tiempoEspera", nullable = true)
    private Time tiempoEspera;
    @Basic
    @Column(name = "total", nullable = false, precision = 0)
    private double total;
    @Basic
    @Column(name = "comentario", nullable = false, length = 200)
    private String comentario;
    @Basic
    @Column(name = "estado", nullable = false, length = 25)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "codigoClient", referencedColumnName = "codigoClient", nullable = false)
    private ClientesEntity clientesByCodigoClient;
    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto", nullable = false)
    private ProductosEntity productosByIdProducto;

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getCodigoClient() {
        return codigoClient;
    }

    public void setCodigoClient(String codigoClient) {
        this.codigoClient = codigoClient;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Time getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(Time tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdenEntity that = (OrdenEntity) o;
        return idOrden == that.idOrden && idProducto == that.idProducto && cantidad == that.cantidad && Double.compare(that.total, total) == 0 && Objects.equals(codigoClient, that.codigoClient) && Objects.equals(fecha, that.fecha) && Objects.equals(tiempoEspera, that.tiempoEspera) && Objects.equals(comentario, that.comentario) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrden, codigoClient, idProducto, cantidad, fecha, tiempoEspera, total, comentario, estado);
    }

    public ClientesEntity getClientesByCodigoClient() {
        return clientesByCodigoClient;
    }

    public void setClientesByCodigoClient(ClientesEntity clientesByCodigoClient) {
        this.clientesByCodigoClient = clientesByCodigoClient;
    }

    public ProductosEntity getProductosByIdProducto() {
        return productosByIdProducto;
    }

    public void setProductosByIdProducto(ProductosEntity productosByIdProducto) {
        this.productosByIdProducto = productosByIdProducto;
    }
}

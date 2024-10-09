package sv.foodboard.www.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "productos", schema = "foodboard", catalog = "")
public class ProductosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProducto", nullable = false)
    private int idProducto;
    @Basic
    @Column(name = "idCategoria", nullable = false)
    private int idCategoria;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = false, precision = 0)
    private double precio;
    @Basic
    @Column(name = "imagen", nullable = false, length = 100)
    private String imagen;
    @Basic
    @Column(name = "tiempo", nullable = false)
    private Time tiempo;
    @Basic
    @Column(name = "estado", nullable = false, length = 25)
    private String estado;
    @OneToMany(mappedBy = "productosByIdProducto")
    private Collection<OrdenEntity> ordensByIdProducto;
    @ManyToOne
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria", nullable = false)
    private CategoriasEntity categoriasByIdCategoria;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Time getTiempo() {
        return tiempo;
    }

    public void setTiempo(Time tiempo) {
        this.tiempo = tiempo;
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
        ProductosEntity that = (ProductosEntity) o;
        return idProducto == that.idProducto && idCategoria == that.idCategoria && Double.compare(that.precio, precio) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(imagen, that.imagen) && Objects.equals(tiempo, that.tiempo) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idCategoria, nombre, descripcion, precio, imagen, tiempo, estado);
    }

    public Collection<OrdenEntity> getOrdensByIdProducto() {
        return ordensByIdProducto;
    }

    public void setOrdensByIdProducto(Collection<OrdenEntity> ordensByIdProducto) {
        this.ordensByIdProducto = ordensByIdProducto;
    }

    public CategoriasEntity getCategoriasByIdCategoria() {
        return categoriasByIdCategoria;
    }

    public void setCategoriasByIdCategoria(CategoriasEntity categoriasByIdCategoria) {
        this.categoriasByIdCategoria = categoriasByIdCategoria;
    }
}

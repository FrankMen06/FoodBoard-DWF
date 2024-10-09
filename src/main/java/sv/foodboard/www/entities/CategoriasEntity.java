package sv.foodboard.www.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "categorias", schema = "foodboard", catalog = "")
public class CategoriasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCategoria", nullable = false)
    private int idCategoria;
    @Basic
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "estado", nullable = false, length = 100)
    private String estado;
    @OneToMany(mappedBy = "categoriasByIdCategoria")
    private Collection<ProductosEntity> productosByIdCategoria;

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
        CategoriasEntity that = (CategoriasEntity) o;
        return idCategoria == that.idCategoria && Objects.equals(nombre, that.nombre) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, nombre, estado);
    }

    public Collection<ProductosEntity> getProductosByIdCategoria() {
        return productosByIdCategoria;
    }

    public void setProductosByIdCategoria(Collection<ProductosEntity> productosByIdCategoria) {
        this.productosByIdCategoria = productosByIdCategoria;
    }
}

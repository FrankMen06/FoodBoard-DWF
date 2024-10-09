package sv.foodboard.www.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "comentario", schema = "foodboard", catalog = "")
public class ComentarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idComentario", nullable = false)
    private int idComentario;
    @Basic
    @Column(name = "comentario", nullable = false, length = 500)
    private String comentario;
    @Basic
    @Column(name = "idProducto", nullable = false)
    private int idProducto;

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComentarioEntity that = (ComentarioEntity) o;
        return idComentario == that.idComentario && idProducto == that.idProducto && Objects.equals(comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComentario, comentario, idProducto);
    }
}

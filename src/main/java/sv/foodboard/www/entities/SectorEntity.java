package sv.foodboard.www.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sector", schema = "foodboard", catalog = "")
public class SectorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_Sector", nullable = false)
    private int idSector;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "capacidad", nullable = false)
    private int capacidad;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;
    @Basic
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;
    @OneToMany(mappedBy = "sectorByIdSector")
    private Collection<MesasEntity> mesasByIdSector;

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        SectorEntity that = (SectorEntity) o;
        return idSector == that.idSector && capacidad == that.capacidad && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSector, nombre, capacidad, descripcion, estado);
    }

    public Collection<MesasEntity> getMesasByIdSector() {
        return mesasByIdSector;
    }

    public void setMesasByIdSector(Collection<MesasEntity> mesasByIdSector) {
        this.mesasByIdSector = mesasByIdSector;
    }
}

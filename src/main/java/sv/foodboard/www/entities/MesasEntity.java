package sv.foodboard.www.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "mesas", schema = "foodboard", catalog = "")
public class MesasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMesa", nullable = false)
    private int idMesa;
    @Basic
    @Column(name = "Capacidad", nullable = false)
    private int capacidad;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;
    @Basic
    @Column(name = "id_Sector", nullable = false)
    private int idSector;
    @Basic
    @Column(name = "Estado", nullable = false, length = 25)
    private String estado;
    @OneToMany(mappedBy = "mesasByIdMesa")
    private Collection<ClientesEntity> clientesByIdMesa;
    @ManyToOne
    @JoinColumn(name = "id_Sector", referencedColumnName = "id_Sector", nullable = false)
    private SectorEntity sectorByIdSector;

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
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

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
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
        MesasEntity that = (MesasEntity) o;
        return idMesa == that.idMesa && capacidad == that.capacidad && idSector == that.idSector && Objects.equals(descripcion, that.descripcion) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMesa, capacidad, descripcion, idSector, estado);
    }

    public Collection<ClientesEntity> getClientesByIdMesa() {
        return clientesByIdMesa;
    }

    public void setClientesByIdMesa(Collection<ClientesEntity> clientesByIdMesa) {
        this.clientesByIdMesa = clientesByIdMesa;
    }

    public SectorEntity getSectorByIdSector() {
        return sectorByIdSector;
    }

    public void setSectorByIdSector(SectorEntity sectorByIdSector) {
        this.sectorByIdSector = sectorByIdSector;
    }
}

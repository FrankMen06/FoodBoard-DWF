package sv.foodboard.www.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "clientes", schema = "foodboard", catalog = "")
public class ClientesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigoClient", nullable = false, length = 8)
    private String codigoClient;
    @Basic
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Basic
    @Column(name = "idMesa", nullable = false)
    private int idMesa;
    @Basic
    @Column(name = "codigo", nullable = false, length = 8)
    private String codigo;
    @Basic
    @Column(name = "tiempo", nullable = true)
    private Integer tiempo;
    @Basic
    @Column(name = "estado", nullable = false, length = 25)
    private String estado;
    @ManyToOne
    @JoinColumn(name = "idMesa", referencedColumnName = "idMesa", nullable = false)
    private MesasEntity mesasByIdMesa;
    @ManyToOne
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", nullable = false)
    private EmpleadosEntity empleadosByCodigo;
    @OneToMany(mappedBy = "clientesByCodigoClient")
    private Collection<OrdenEntity> ordensByCodigoClient;

    public String getCodigoClient() {
        return codigoClient;
    }

    public void setCodigoClient(String codigoClient) {
        this.codigoClient = codigoClient;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
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
        ClientesEntity that = (ClientesEntity) o;
        return idMesa == that.idMesa && Objects.equals(codigoClient, that.codigoClient) && Objects.equals(apellido, that.apellido) && Objects.equals(codigo, that.codigo) && Objects.equals(tiempo, that.tiempo) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoClient, apellido, idMesa, codigo, tiempo, estado);
    }

    public MesasEntity getMesasByIdMesa() {
        return mesasByIdMesa;
    }

    public void setMesasByIdMesa(MesasEntity mesasByIdMesa) {
        this.mesasByIdMesa = mesasByIdMesa;
    }

    public EmpleadosEntity getEmpleadosByCodigo() {
        return empleadosByCodigo;
    }

    public void setEmpleadosByCodigo(EmpleadosEntity empleadosByCodigo) {
        this.empleadosByCodigo = empleadosByCodigo;
    }

    public Collection<OrdenEntity> getOrdensByCodigoClient() {
        return ordensByCodigoClient;
    }

    public void setOrdensByCodigoClient(Collection<OrdenEntity> ordensByCodigoClient) {
        this.ordensByCodigoClient = ordensByCodigoClient;
    }
}

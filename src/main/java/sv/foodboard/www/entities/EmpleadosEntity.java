package sv.foodboard.www.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empleados", schema = "foodboard", catalog = "")
public class EmpleadosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo", nullable = false, length = 8)
    private String codigo;
    @Basic
    @Column(name = "contraseña", nullable = false, length = 200)
    private String contraseña;
    @Basic
    @Column(name = "nombre1", nullable = false, length = 100)
    private String nombre1;
    @Basic
    @Column(name = "nombre2", nullable = false, length = 100)
    private String nombre2;
    @Basic
    @Column(name = "apellido1", nullable = false, length = 100)
    private String apellido1;
    @Basic
    @Column(name = "apellido2", nullable = false, length = 100)
    private String apellido2;
    @Basic
    @Column(name = "correo", nullable = false, length = 200)
    private String correo;
    @Basic
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;
    @Basic
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic
    @Column(name = "fechaNac", nullable = false)
    private Date fechaNac;
    @Basic
    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;
    @Basic
    @Column(name = "municipio", nullable = false, length = 200)
    private String municipio;
    @Basic
    @Column(name = "departamento", nullable = false, length = 200)
    private String departamento;
    @Basic
    @Column(name = "sexo", nullable = false, length = 20)
    private String sexo;
    @Basic
    @Column(name = "estadoCivil", nullable = false, length = 50)
    private String estadoCivil;
    @Basic
    @Column(name = "rol", nullable = false, length = 25)
    private String rol;
    @Basic
    @Column(name = "estado", nullable = false, length = 25)
    private String estado;
    @OneToMany(mappedBy = "empleadosByCodigo")
    private Collection<ClientesEntity> clientesByCodigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        EmpleadosEntity that = (EmpleadosEntity) o;
        return Objects.equals(codigo, that.codigo) && Objects.equals(contraseña, that.contraseña) && Objects.equals(nombre1, that.nombre1) && Objects.equals(nombre2, that.nombre2) && Objects.equals(apellido1, that.apellido1) && Objects.equals(apellido2, that.apellido2) && Objects.equals(correo, that.correo) && Objects.equals(telefono, that.telefono) && Objects.equals(dui, that.dui) && Objects.equals(fechaNac, that.fechaNac) && Objects.equals(direccion, that.direccion) && Objects.equals(municipio, that.municipio) && Objects.equals(departamento, that.departamento) && Objects.equals(sexo, that.sexo) && Objects.equals(estadoCivil, that.estadoCivil) && Objects.equals(rol, that.rol) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, contraseña, nombre1, nombre2, apellido1, apellido2, correo, telefono, dui, fechaNac, direccion, municipio, departamento, sexo, estadoCivil, rol, estado);
    }

    public Collection<ClientesEntity> getClientesByCodigo() {
        return clientesByCodigo;
    }

    public void setClientesByCodigo(Collection<ClientesEntity> clientesByCodigo) {
        this.clientesByCodigo = clientesByCodigo;
    }
}

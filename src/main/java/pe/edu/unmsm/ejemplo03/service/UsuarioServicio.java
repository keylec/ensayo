package pe.edu.unmsm.ejemplo03.service;

import pe.edu.unmsm.ejemplo03.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {
    public List<Usuario> findAll();
    public Usuario findById(Integer id);
    public Usuario findByPassword(String password);

    public void ingresarUsuario(Usuario usuario);
}

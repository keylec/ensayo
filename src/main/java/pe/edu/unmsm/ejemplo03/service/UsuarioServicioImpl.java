package pe.edu.unmsm.ejemplo03.service;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.ejemplo03.entidades.Usuario;

import java.util.List;
@Repository
@Transactional
public class UsuarioServicioImpl implements UsuarioServicio{
    @Autowired
    EntityManager entityManager;
    @Override
    @Transactional
    public List<Usuario> findAll() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario findById(Integer id) {
        String query = "FROM Usuario WHERE id = "+id+"";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        if (lista.isEmpty()) {
            return null;
        }
        return lista.get(0);

    }

    @Override
    public Usuario findByPassword(String password) {
        return null;
    }

    @Override
    public void ingresarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }
}

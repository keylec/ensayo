package pe.edu.unmsm.ejemplo03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.ejemplo03.entidades.Usuario;
import pe.edu.unmsm.ejemplo03.service.UsuarioServicio;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @RequestMapping("/todos")
    public List<Usuario> findAll(){
        return usuarioServicio.findAll();
    }
    @RequestMapping("/ver/{id}")
    public Usuario codigo(@PathVariable Integer id) {
        Usuario usuario = usuarioServicio.findById(id);
        return usuario;
    }

    @RequestMapping(value = "/nuevo",method = RequestMethod.POST)
    public @ResponseBody Integer add(@RequestParam String nombre,@RequestParam String apellido,
                                     @RequestParam String telefono,
                                     @RequestParam String email,
                                     @RequestParam String password){
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuarioServicio.ingresarUsuario(usuario);
        return usuario.getId();
    }
}

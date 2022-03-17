package com.art3.mili.controlador;


import com.art3.mili.modelo.entidad.Usuario;
import com.art3.mili.modelo.servicio.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;


    @GetMapping()
    public ResponseEntity<List<Usuario>> obtenerTodos(){
        Optional<List<Usuario>> usuarios = usuarioService.obtenerTodos();
        return new ResponseEntity<>(usuarios.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") int id){
        Optional<Usuario> miUsuario = usuarioService.obtenerPorId(id);
        return (miUsuario.isPresent()
                ? new ResponseEntity<>(miUsuario.get(),HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping()
    public ResponseEntity<Usuario> validarCredenciales(@RequestBody Usuario usuario){
        Optional<Usuario> miUsuario = usuarioService.validarCredenciales(usuario.getNombreUsuario(), usuario.getClave());
        if(miUsuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(miUsuario.get(),HttpStatus.ACCEPTED);
        }
    }


    @PostMapping("/create")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity actualizarUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(
                usuarioService.actualizarUsuario(usuario)
                ? HttpStatus.OK
                : HttpStatus.EXPECTATION_FAILED
        );
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        return new ResponseEntity<>(
                usuarioService.eliminarUsuarioPorId(id)
                        ? HttpStatus.OK
                        : HttpStatus.NOT_FOUND
        );
    }
}

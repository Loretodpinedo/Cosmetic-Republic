package cosmetic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cosmetic.modelo.persistencia.AtributoCosmeticoDao;
import cosmetic.modelo.entidad.AtributoCosmetico;

@RestController
class AtributoCosmeticoControlador {

    private final AtributoCosmeticoDao atributo;

    AtributoCosmeticoControlador(AtributoCosmeticoDao atributo) {
        this.atributo = atributo;
    }

    @GetMapping("/AtributosCosmeticos")
    List<AtributoCosmetico> listar() {
        return atributo.findAll();
    }

    @PostMapping("/AtributoCosmetico")
    AtributoCosmetico altaAtributoCosmetico(@RequestBody AtributoCosmetico nuevoAtributoCosmetico) {
        return atributo.save(nuevoAtributoCosmetico);
    }

    // Single item
    @GetMapping("/AtributoCosmetico/{id}")
    AtributoCosmetico obtener(@PathVariable Long id) {

       
        return atributo.findById(id.intValue());
    }

    @PutMapping("/AtributoCosmetico/{id}")
    AtributoCosmetico modificarAtributoCosmetico(@RequestBody AtributoCosmetico nuevoAtributoCosmetico,
            @PathVariable Long id) {

        AtributoCosmetico atributoObj = null;
        atributoObj = atributo.findById(id.intValue());
        if (atributo == null) {
            atributoObj = new AtributoCosmetico();
        }

        atributoObj.setNombre(nuevoAtributoCosmetico.getNombre());
        // atributo_obj.setNombre(newAtributoCosmetico.getNombre());

        return atributoObj;

    }

    @DeleteMapping("/AtributoCosmetico/{id}")
    void borrarAtributoCosmetico(@PathVariable Long id) {
        atributo.deleteById(id.intValue());
    }
}
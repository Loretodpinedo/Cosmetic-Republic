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

    @PostMapping("/AtributosCosmetico")
    AtributoCosmetico altaAtributoCosmetico(@RequestBody AtributoCosmetico NuevoAtributoCosmetico) {
        return atributo.save(NuevoAtributoCosmetico);
    }

    // Single item
    @GetMapping("/AtributosCosmetico/{id}")
    AtributoCosmetico obtener(@PathVariable Long id) {

       
        return atributo.findById(id.intValue());
    }

    @PutMapping("/AtributosCosmetico/{id}")
    AtributoCosmetico modificarAtributoCosmetico(@RequestBody AtributoCosmetico newAtributoCosmetico,
            @PathVariable Long id) {

        AtributoCosmetico atributo_obj = null;
        atributo_obj = atributo.findById(id.intValue());
        if (atributo == null) {
            atributo_obj = new AtributoCosmetico();
        }

        atributo_obj.setNombre(newAtributoCosmetico.getNombre());
        // atributo_obj.setNombre(newAtributoCosmetico.getNombre());

        return atributo_obj;

    }

    @DeleteMapping("/AtributoCosmetico/{id}")
    void borrarAtributoCosmetico(@PathVariable Long id) {
        atributo.deleteById(id.intValue());
    }
}
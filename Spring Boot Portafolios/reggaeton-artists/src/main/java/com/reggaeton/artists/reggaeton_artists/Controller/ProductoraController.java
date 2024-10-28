package com.reggaeton.artists.reggaeton_artists.Controller;

import com.reggaeton.artists.reggaeton_artists.Entity.Productora;
import com.reggaeton.artists.reggaeton_artists.Service.ProductoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductoraController {

    @Autowired
    private ProductoraService service;

    /*This method is for showing Productora Data*/
    @GetMapping("/productora")
    public String productora (Model modelo) {
    modelo.addAttribute("productora" ,service.listAllProductora() );
        return "productora/productora";
    }

    /*This method is for creating or adding new Productora*/
    @GetMapping("/productora/new")
    public String formForCreatinNewProductora(Model modelo){
        Productora productora = new Productora();
        modelo.addAttribute("productora" , productora);
        return "productora/newProductora";
    }

    /*This method is for saving the productora*/
    @PostMapping("/productora")
    public String saveProductora(@ModelAttribute ("productora") Productora productora){
        service.saveProductora(productora);
        return "redirect:/main";
    }

    @GetMapping("/productora/edit/{id}")
    public String showFormUpdateProductora(@PathVariable Long id, Model modelo){
    modelo.addAttribute("productora" , service.getProductoraById(id));
    return "productora/updateProductora";
    }

    /*This method is for updating the productora -- WORKED 23 OCTOBER 2024*/
    @PostMapping("/productora/{id}")
    public String updateProductora(@PathVariable Long id, @ModelAttribute("productora") Productora productora, RedirectAttributes redirectAttributes) {

        try {
            Productora productoraExistente = service.getProductoraById(id);

            // Actualizamos las propiedades de la entidad existente
            productoraExistente.setName(productora.getName());
            productoraExistente.setUbication(productora.getUbication());
            productoraExistente.setFundation(productora.getFundation());

            // Llamamos al método de actualización
            Productora productoraActualizada = service.updateProductora(productoraExistente);

            // Verificamos si la actualización fue exitosa
            if (productoraActualizada != null) {
                redirectAttributes.addFlashAttribute("status", "success");
                redirectAttributes.addFlashAttribute("message", "¡La productora se ha actualizado correctamente!");
            } else {
                redirectAttributes.addFlashAttribute("status", "error");
                redirectAttributes.addFlashAttribute("message", "No se pudo realizar la actualización de la productora.");
            }

        } catch (Exception e) {
            // Manejamos cualquier excepción que ocurra durante la actualización
            redirectAttributes.addFlashAttribute("status", "error");
            redirectAttributes.addFlashAttribute("message", "Ocurrió un error al actualizar la productora: " + e.getMessage());
        }

        return "redirect:/productora"; // Regresar a la vista para mostrar el mensaje
    }


    /*This method is for deleting the productora -- WORKED 22 OCTOBER 2024*/
    @PostMapping("/productora/{id}/delete")
    public String deleteProductora(@PathVariable Long id, RedirectAttributes redirectAttributes){
        //RedirectAttributes
        /*Para manejar mensajes de error utilizaremos esto nos servira a almacenar los mensajes que queremos que se
         muestren depues del rediresonamiento */

        //Validacion
        /*Si el registro se elimina nos reenviara a  "redirect:/productora"
        *El registro no se elimina se hara una validacion y mostrara un mensaje de error
        * */
        try{
            service.deleteProductora(id);
            redirectAttributes.addFlashAttribute("success", "Successfully delete Discographic  selleout");
            return"redirect:/productora";
        }catch (DataIntegrityViolationException e){
            /*DESCRIPCION DEL CODIGO*/
            // redirectAttributes  -> este objecto nos permite pasar atributos entre el controlador y la vista durante una redireccion

            // addFlashAttribute   -> Este es un metodo , asi que los atributos flash son temporales se utilizan
            // para mostrar mensajes de error , exito o informacion

            //error                ->  Este es el nombre del atributo que se esta agregando , en la vista podemos acceder a este atributo
            //                         usando este nombre para mostrar el mensaje de error correspondiente

            //You can delete       -> Este es el mensaje que se mostrar a los usuarios cuando intente eliminar un sello discografico (productora)
            //                        que tiene productores asociados

            redirectAttributes.addFlashAttribute("error", "You can delete this record because a producer is associated with Discographic  selleout");
            return"redirect:/productora";
        }


    }

    /*22nd October 2024
    * Developer Luis Rdrgz
    * Today I created and worked In deleteProductora Method
    * A validation was made , for when the record cannot be deleted or if it can be deleted
    * */


    /*23nd October 2024
    * Developer Luis Rdrgz
    *
    *
    * */
}

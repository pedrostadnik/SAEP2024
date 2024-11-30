package senai.br.saep.Controller;


import senai.br.saep.service.S_Cadastro;
import senai.br.saep.model.M_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class C_Cadastro {

    private final S_Cadastro s_cadastro;

    // Injeta o serviço no controlador através do construtor
    public C_Cadastro(S_Cadastro s_cadastro) {
        this.s_cadastro = s_cadastro;
    }

    @GetMapping("/cadastrar")
    public String getCadastro(){
        return "/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String postCadastro(@RequestParam("username") String username,
                               @RequestParam("email") String email,
                               Model model) {
        System.out.println("Requisição recebida: " + username);
        // Se o login for bem-sucedido
        if (s_cadastro.validaCadastro(username, email)){
            return "home/home";
        }
        return "redirect:/cadastrar";
    }
}

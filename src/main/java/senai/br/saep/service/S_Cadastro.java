package senai.br.saep.service;


import org.springframework.stereotype.Service;
import senai.br.saep.model.M_Usuario;
import senai.br.saep.repository.R_Usuario;

@Service
public class S_Cadastro {

    private static R_Usuario r_usuario;


    public S_Cadastro(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    // Método para validar o cadastro
    public static boolean validaCadastro(String username,  String email) {
        boolean podeSalvar = true;
        M_Usuario m_usuario = new M_Usuario();

        try {
            // Aqui você pode adicionar a lógica para validar os dados
            if (username == null ||  email == null ) {
                podeSalvar = false; // Retorna false se algum campo estiver vazio
            }
        }
        catch (Exception e){
            podeSalvar = false;
        }

        if (podeSalvar){
            m_usuario.setUsername(username);

            m_usuario.setEmail(email);

            m_usuario = r_usuario.save(m_usuario);
            System.out.println("deu bao so confira");
        }

        return podeSalvar;
    }



}

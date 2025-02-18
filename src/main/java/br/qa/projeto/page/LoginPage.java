package br.qa.projeto.page;

import br.qa.projeto.core.BasePage;

public class LoginPage extends BasePage {

    public void setUsuario(){
        dsl.escrever("id_cod_usuario", "987654321");
    }

    public void setSenha(){
        dsl.escrever("nom_senha", "victor.silva/#jmbo2022$");
    }

    public void setClicarLogin(){
        dsl.clicar("login");
    }

    public void setClicarCadastros(){
        dsl.clicarPorLink("Cadastros");
    }

    public void setClicarClientesEConvenios(){
        dsl.clicarPorCssSelector("#ul1 > li:nth-child(2) > a > span");
    }

    public void setClicarClientes(){
        dsl.clicarPorCssSelector("#ul110 > .tng-nav-menu-item:nth-child(1) span");
    }






}

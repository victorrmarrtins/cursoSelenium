package br.qa.projeto.page;

import br.qa.projeto.core.BasePage;
import br.qa.projeto.core.DSL;
import org.openqa.selenium.WebDriver;

public class CadastroClientePage extends BasePage {

    public void setNome() {
        dsl.escrever("nom_cliente", "TESTE DE CLIENTE MAX CARACTER !@#$%¨&*()");
    }

    public void setCPFouCNPJ() {
        dsl.escrever("num_cnpj", "10001285980");
    }

    public void setTipoDeContribuinteContribuinte() {
        dsl.selecionarCombo("tip_indiedest", "CONTRIBUINTE ICMS");
    }

    public void setTipoDeContribuinteNaoContribuinte() {
        dsl.selecionarCombo("tip_indiedest", "NÃO CONTRIBUINTE");
    }

    public void setIdentidadeIE(){
        dsl.escrever("num_ident", "ISENTO");
    }

    public void setUfEmissora(){
        dsl.selecionarCombo("est_emissor", "SC - SANTA CATARINA");
    }

    public void setCEP(){
        dsl.escrever("cep_cliente", "88702430");
        dsl.escreverEnter("cep_cliente", "88702430");

    }

    public void setNumeroEndereco(){
        dsl.escrever("num_endereco", "KL");
        dsl.escreverEnter("num_endereco", "KL");
    }

    public void setTelefone(){
        dsl.escrever("num_fone", "22222222222");
    }

    public void setGrupo(){
        dsl.escrever("cod_grupoEntrada", "1");
        dsl.escreverEnter("cod_grupoEntrada", "1");
    }

    public void setClicarEmpresa(){
        dsl.clicar("cod_empresaEntrada");
    }

    public void setEmpresa(){
        dsl.escrever("cod_empresaEntrada", "1");
        dsl.escreverEnter("cod_empresaEntrada", "1");
    }

    public void setClicarInfoAdicionais(){
        dsl.clicarPorLink("Inf. Vendas");
    }

    public void setTabResponLegal(){
        dsl.tab("nomResponLegal");
    }

    public void setSalvar(){
        dsl.clicar("btSalvarGeral");
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author marcelo.soares
 */
public class SeleniumTestTrabalho {
    
      static WebDriver driver = null;
      
      private static String namePaginaPrincipal ;
    public SeleniumTestTrabalho() {
    }
    
    @BeforeClass
    public static void setUp() {
        //onde está o chrome driver da aplicação
         System.setProperty("webdriver.chrome.driver", 
	                "C:\\chromedriver_win32\\chromedriver.exe");
	        
        
         driver = new ChromeDriver();

        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
    
        namePaginaPrincipal = driver.getWindowHandle();
    }
    
    
    
   
   
    
    
     @Test
    public void testNomeValido(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
        //pode ser caixa de texto,foto, 
        WebElement nomeValido = driver.findElement(By.id("nome"));
        WebElement submit = driver.findElement(By.id("botao_somar"));
        nomeValido.sendKeys("Tiago");
         submit.click();
        WebElement resultado = driver.findElement(By.id("resultado"));
         Assert.assertEquals("Preencha o campo endereco", resultado.getText());
        
    }
    
     @Test
    public void testNomeInvalido(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
       WebElement nomeInvalido = driver.findElement(By.id("nome"));
        WebElement submit = driver.findElement(By.id("botao_somar"));
        nomeInvalido.sendKeys("");
         submit.click();
        WebElement resultado = driver.findElement(By.id("resultado"));
         Assert.assertEquals("Preencha o campo nome", resultado.getText());
        
    }
    
     @Test
    public void testEnderecoValido(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
        WebElement nomeValido = driver.findElement(By.id("nome"));
       WebElement endereco = driver.findElement(By.id("endereco"));
        WebElement submit = driver.findElement(By.id("botao_somar"));
         nomeValido.sendKeys("Tiago");
        endereco.sendKeys("Rui Ramos");
         submit.click();
        WebElement resultado = driver.findElement(By.id("resultado"));
         Assert.assertEquals("Selecione um valor para o campo sexo", resultado.getText());
        
    }
    @Test
    public void testEnderecoInvalido(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
        WebElement nomeValido = driver.findElement(By.id("nome"));
       WebElement endereco = driver.findElement(By.id("endereco"));
        WebElement submit = driver.findElement(By.id("botao_somar"));
         nomeValido.sendKeys("Tiago");
        endereco.sendKeys("");
         submit.click();
        WebElement resultado = driver.findElement(By.id("resultado"));
         Assert.assertEquals("Preencha o campo endereco", resultado.getText());
        
    }
    
    @Test
    public void testCampoSexoValido(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
        
      WebElement nomeValido = driver.findElement(By.id("nome"));
      WebElement endereco = driver.findElement(By.id("endereco"));
     
      WebElement submit = driver.findElement(By.id("botao_somar"));
      Select selec  = new Select (driver.findElement(By.id("sexo")));
      nomeValido.sendKeys("Tiago");
      endereco.sendKeys("Rui Ramos");
      selec.selectByVisibleText("Feminino");
      submit.click();
      WebElement resultado = driver.findElement(By.id("resultado"));
      Assert.assertEquals("Preencha o campo idade, somente com numeros", resultado.getText());
        
    }
   
    @Test
    public void testCampoSexoInvalido(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
        
      WebElement nomeValido = driver.findElement(By.id("nome"));
      WebElement endereco = driver.findElement(By.id("endereco"));
     
      WebElement submit = driver.findElement(By.id("botao_somar"));
      Select selec  = new Select (driver.findElement(By.id("sexo")));
      nomeValido.sendKeys("Tiago");
      endereco.sendKeys("Rui Ramos");
      selec.selectByVisibleText("...");
      submit.click();
      WebElement resultado = driver.findElement(By.id("resultado"));
      Assert.assertEquals("Selecione um valor para o campo sexo", resultado.getText());
        
    }
    
    
   
    @Test
    public void testCampoIdadeInvalidoMenorQueZero(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
        
      WebElement nomeValido = driver.findElement(By.id("nome"));
      WebElement endereco = driver.findElement(By.id("endereco"));
     
      WebElement submit = driver.findElement(By.id("botao_somar"));
      Select selec  = new Select (driver.findElement(By.id("sexo")));
      WebElement idade = driver.findElement(By.id("idade"));
      nomeValido.sendKeys("Tiago");
      endereco.sendKeys("Rui Ramos");
      selec.selectByVisibleText("Masculino");
      idade.sendKeys("-1");
      submit.click();
      WebElement resultado = driver.findElement(By.id("resultado"));
      Assert.assertEquals("Preencha o campo idade com valores acima de 0", resultado.getText());
        
    }
    
  @Test
    public void testCampoIdadeInvalidoApenasNumeros(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
        
      WebElement nomeValido = driver.findElement(By.id("nome"));
      WebElement endereco = driver.findElement(By.id("endereco"));
     
      WebElement submit = driver.findElement(By.id("botao_somar"));
      Select selec  = new Select (driver.findElement(By.id("sexo")));
      WebElement idade = driver.findElement(By.id("idade"));
      nomeValido.sendKeys("Tiago");
      endereco.sendKeys("Rui Ramos");
      selec.selectByVisibleText("Masculino");
      idade.sendKeys("ABC");
      submit.click();
      WebElement resultado = driver.findElement(By.id("resultado"));
      Assert.assertEquals("Preencha o campo idade, somente com numeros", resultado.getText());
        
    }
    
    @Test
    public void testCampoIdadeValidoEFormularioCompleto(){
        driver.get("C:\\Users\\tiago\\Downloads\\TrabalhoTiago\\TrabalhoTiago\\TrabalhoTiago\\src\\trabalho2-1.html");
        
      WebElement nomeValido = driver.findElement(By.id("nome"));
      WebElement endereco = driver.findElement(By.id("endereco"));
     
      WebElement submit = driver.findElement(By.id("botao_somar"));
      Select selec  = new Select (driver.findElement(By.id("sexo")));
      WebElement idade = driver.findElement(By.id("idade"));
      nomeValido.sendKeys("Tiago");
      endereco.sendKeys("Rui Ramos");
      selec.selectByVisibleText("Masculino");
      idade.sendKeys("25");
      submit.click();
      //WebElement resultado = driver.findElement(By.id("resultado"));
      String textAlert =  driver.switchTo().alert().getText();
      driver.switchTo().alert().accept();
      Assert.assertEquals("Cadastro realizado com sucesso", textAlert);
        
    }
          
    @Test
    public void testeTituloPagina(){
        
        String titulo = driver.getTitle();
        Assert.assertEquals("Trabalho 2-1", titulo);
        
    }
    
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    
}

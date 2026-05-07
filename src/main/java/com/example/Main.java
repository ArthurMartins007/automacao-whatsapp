
package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        System.out.println("Configurando o robô...");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\arthu\\PerfilRoboWhatsApp");
        WebDriver driver = new ChromeDriver(options);

        try {
            // 2. Abre o WhatsApp
            driver.get("https://web.whatsapp.com");
            System.out.println("Você tem 20 segundos para escanear o QR Code!");
            Thread.sleep(20000);

            // 3. Le a planilha
            BufferedReader leitor = new BufferedReader(new FileReader("teste.csv"));
            String linha;

            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                String telefone = dados[1];

                // 4. Monta a mensagem personalizada
                String mensagem = "Fala " + nome + "! teste teste";
                String msgCodificada = URLEncoder.encode(mensagem, StandardCharsets.UTF_8);

                // 5. Entra no link direto de conversa do WhatsApp
                String linkZap = "https://web.whatsapp.com/send?phone=" + telefone + "&text=" + msgCodificada;
                driver.get(linkZap);

                System.out.println("Preparando para enviar para: " + nome);

                // Espera a página da conversa carregar
                Thread.sleep(12000);

                // 6. Procura o botão de enviar e clica nele
                driver.switchTo().activeElement().sendKeys(Keys.ENTER);

                System.out.println("Mensagem enviada com sucesso!");

                // Gera um tempo aleatório entre 10 e 20 segundos
                int tempoEspera = (int) (Math.random() * 10000) + 10000;
                System.out.println("Aguardando " + (tempoEspera / 1000) + " segundos antes do próximo envio.");
                Thread.sleep(tempoEspera);
            }
            leitor.close();

        } catch (Exception e) {
            System.out.println("Opa, deu algum erro: " + e.getMessage());
        } finally {
            // 7. Fecha o navegador no final
            System.out.println("Finalizando o robô...");
            driver.quit();
        }
    }
}
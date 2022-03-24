
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {

	public static void main(String[] args) {
		
		String meuEmail = "prluciohermano@gmail.com";
		String minhaSenha = "618Lucio618";
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
		email.setSSLOnConnect(true);
		
		try {
			email.setFrom(meuEmail);
			email.setSubject("Teste de E-mail com Anexo");
			email.setMsg("Testando como enviar um e-mail com anexo através de um programa Java");
			email.addTo(meuEmail);
			email.send();
			System.out.println("Email foi enviado com sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

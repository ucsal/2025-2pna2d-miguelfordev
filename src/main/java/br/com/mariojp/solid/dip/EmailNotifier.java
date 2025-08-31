package br.com.mariojp.solid.dip;

public class EmailNotifier {
	//private final SmtpClient smtp = new SmtpClient();

	private final MailSender smtp;
	
	public EmailNotifier() {
		this.smtp = createSmtp();
	}
	
	private MailSender createSmtp() {
		if ("true".equalsIgnoreCase(System.getProperty("DRY_RUN"))) {
			// Estado inicial: ainda assim usa SMTP real (bug proposital)
			return new SmtpTest();
		}
		return new SmtpClient();
	}
	
	public void welcome(User user) {
		smtp.send(user.email(), "Bem-vindo", "Olá " + user.name());
	}
}

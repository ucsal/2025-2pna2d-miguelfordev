package br.com.mariojp.solid.dip;

public class SmtpTest implements MailSender {

	@Override
	public void send(String to, String subject, String body) {
		System.out.println("Teste dry_run para: "+to);
	}

}

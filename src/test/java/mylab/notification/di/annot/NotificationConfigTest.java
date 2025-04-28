package mylab.notification.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.config.NotificationConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	
	@Autowired
	NotificationManager notificationManager;
	
	@Autowired
	@Qualifier("emailNotificationService")
	EmailNotificationService emailService;
	
	@Autowired
	@Qualifier("smsNotificationService")
	SmsNotificationService smsService;
	
	@Test
	void testNotificationManager() {
		assertNotNull(notificationManager);
		assertNotNull(emailService);
		assertNotNull(smsService);
		
		assertEquals("smtp.gmail.com", emailService.getSmtpServer());
		assertEquals(587, emailService.getPort());
		assertEquals("SKT", smsService.getProvider());
	}
}

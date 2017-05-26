package test.com.lapsa.mail2;

import static test.com.lapsa.mail.MailSessionHelper.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.lapsa.mail2.MailException;
import com.lapsa.mail2.MailFactory;
import com.lapsa.mail2.MailFactoryBuilder;

public class SendTestCase {

    private static final String PATH_TO_TEST_RESOURCE = "policy_sample.jpg";
    private static final String PATH_TO_TEST_FILE = "src/test/resources/policy_sample.jpg";

    private MailFactory factory;

    @Before
    public void prepareSession() throws MailException {
	factory = MailFactoryBuilder
		.newBuilder()
		.withProperties(MailSessionHelper.PROPERTIES)
		.build();
    }

    @Test
    public void testSend1() throws MailException, IOException {
	factory.newMailBuilder()
		.withTORecipient(MAIL_TEST_RECIPIENT_ADDRESS)
		.withSubject(this.getClass().getName() + ".testSend1")
		.withPartText(this.getClass().getName() + ".testSend1")
		.withAttachement(testFileBytes(), "image/jpeg", "PICTURE.jpg")
		.build()
		.send();
    }

    @Test
    public void testSend2() throws MailException, IOException {
	factory.newMailBuilder()
		.withTORecipient(MAIL_TEST_RECIPIENT_ADDRESS)
		.withSubject(this.getClass().getName() + ".testSend2")
		.withPartText(this.getClass().getName() + ".testSend2")
		.withAttachement(testFileInputStream(), "image/jpeg", "PICTURE.jpg")
		.build()
		.send();
    }

    @Test
    public void testSend3() throws MailException, IOException {
	factory.newMailBuilder()
		.withTORecipient(MAIL_TEST_RECIPIENT_ADDRESS)
		.withSubject(this.getClass().getName() + ".testSend3")
		.withPartText(this.getClass().getName() + ".testSend3")
		.withAttachement(new File(PATH_TO_TEST_FILE))
		.build()
		.send();
    }

    private InputStream testFileInputStream() {
	return this.getClass().getClassLoader().getResourceAsStream(PATH_TO_TEST_RESOURCE);
    }

    private byte[] testFileBytes() throws IOException {
	try (InputStream is = testFileInputStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	    byte[] buff = new byte[256];
	    int readed;
	    while ((readed = is.read(buff)) != -1)
		baos.write(buff, 0, readed);
	    return baos.toByteArray();
	}
    }

}

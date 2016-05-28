package com.lapsa.mailutil.impl;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

import com.lapsa.mailutil.MailMessagePart;
import com.lapsa.mailutil.MailMessageTextPart;

class MultiPartTextProvider implements MultiPartProvider {
    public BodyPart getBodyPart(MailMessagePart part) throws MessagingException {
	MimeBodyPart result = new MimeBodyPart();
	MailMessageTextPart p = (MailMessageTextPart) part;

	// result.setText(mmtp.getText(), "UTF-8", "plain");
	result.setText(p.getText(), p.getCharset().name(), "plain");
	if (p.getContentID() != null)
	    result.setContentID(String.format("<%1$s>", p.getContentID()));
	return result;
    }
}

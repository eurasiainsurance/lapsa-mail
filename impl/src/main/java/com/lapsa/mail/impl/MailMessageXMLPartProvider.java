package com.lapsa.mail.impl;

import java.io.UnsupportedEncodingException;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

import com.lapsa.mail.MailMessagePart;
import com.lapsa.mail.MailMessageXMLPart;

class MailMessageXMLPartProvider implements MultiPartProvider {
    public BodyPart getBodyPart(MailMessagePart part) throws MessagingException {
	MimeBodyPart result = new MimeBodyPart();
	MailMessageXMLPart p = (MailMessageXMLPart) part;

	String content;
	try {
	    content = DOMUtils.getInstance().getAsString(p.getDocument(), p.getCharset().name());
	} catch (UnsupportedEncodingException e) {
	    throw new MessagingException("Unsupported encoding '" + p.getCharset().name() + "'", e);
	}
	result.setText(content, p.getCharset().name(), "xml");
	if (p.getContentID() != null)
	    result.setContentID(String.format("<%1$s>", p.getContentID()));
	return result;
    }
}
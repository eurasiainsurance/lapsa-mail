package com.lapsa.mail.impl;

import java.io.File;
import java.io.IOException;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

import com.lapsa.mail.MailMessageFilePart;

final class DefaultMailMessageFilePart extends AMailMessagePart implements MailMessageFilePart {
    private static final long serialVersionUID = 4611441096903782036L;

    final File file;
    final String contentId;

    DefaultMailMessageFilePart(final DefaultMailService service, final File file) {
	this(service, file, null);
    }

    DefaultMailMessageFilePart(final DefaultMailService service, final File file, final String contentId) {
	super(service, contentId);
	this.file = file;
	this.contentId = contentId;
    }

    @Override
    public BodyPart getBodyPart() throws MessagingException {
	try {
	    final MimeBodyPart result = new MimeBodyPart();
	    result.attachFile(file);
	    putContentId(result);
	    return result;
	} catch (final IOException e) {
	    throw new MessagingException("Unable to attach file", e);
	}
    }
}

package com.lapsa.mail2.impl;

import static com.lapsa.mail2.impl.Checks.*;

import java.util.Objects;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;

import com.lapsa.mail2.MailBuilderException;

abstract class AbstractPartDataSource extends AbstractPart {
    private static final long serialVersionUID = -3710383934434838684L;

    AbstractPartDataSource(final DefaultMailFactory service,
	    final DataSource dataSource,
	    final String fileName,
	    final DispositionType dispositionType,
	    final String contentId) throws MailBuilderException {
	super(service, fileName, dispositionType, contentId);
	try {
	    final DataHandler dh = new DataHandler(
		    Objects.requireNonNull(dataSource, "Datasource data can not be null"));
	    mimePart.setDataHandler(dh);
	} catch (MessagingException e) {
	    throw builderWrapException(e);
	}
    }
}

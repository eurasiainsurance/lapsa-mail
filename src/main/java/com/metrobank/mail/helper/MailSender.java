package com.metrobank.mail.helper;

import java.util.Collection;

import com.metrobank.mail.helper.impl.InvalidMessageException;

public interface MailSender {
    void setAlwaysBlindCopyTo(MailAddress bccAddress);

    void send(MailMessage message) throws MailHelperException, InvalidMessageException;

    void send(MailMessage message, MailSendProtocol protocol) throws MailHelperException,
	    InvalidMessageException;

    void send(Collection<MailMessage> messages) throws MailHelperException, InvalidMessageException;

    void send(Collection<MailMessage> messages, MailSendProtocol protocol) throws MailHelperException,
	    InvalidMessageException;

    void send(MailMessage[] messages) throws MailHelperException, InvalidMessageException;

    void send(MailMessage[] messages, MailSendProtocol protocol) throws MailHelperException,
	    InvalidMessageException;
}

package com.metrobank.mail.helper.impl;

import java.nio.charset.Charset;

import org.w3c.dom.Document;

import com.metrobank.mail.helper.MailMessageXMLPart;

class MailMessageXMLPartImpl implements MailMessageXMLPart {

    private Charset charset;
    private Document doc;

    MailMessageXMLPartImpl(Document doc, Charset charset) {
	this.doc = doc;
	this.charset = charset;
    }

    public Charset getCharset() {
	return charset;
    }

    public Document getDocument() {
	return doc;
    }

}

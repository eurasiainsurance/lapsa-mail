package com.lapsa.mailutil.impl;

import java.nio.charset.Charset;

import org.w3c.dom.Document;

import com.lapsa.mailutil.MailMessageXMLPart;

class MailMessageXMLPartImpl implements MailMessageXMLPart {

    private Charset charset;
    private Document doc;
    private String contentId;

    MailMessageXMLPartImpl(Document doc, Charset charset) {
	this.doc = doc;
	this.charset = charset;
    }

    MailMessageXMLPartImpl(Document doc, Charset charset, String contentId) {
	this.doc = doc;
	this.charset = charset;
	this.contentId = contentId;
    }

    public Charset getCharset() {
	return charset;
    }

    public Document getDocument() {
	return doc;
    }

    @Override
    public String getContentID() {
	return contentId;
    }
}

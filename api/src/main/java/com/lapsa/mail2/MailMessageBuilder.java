package com.lapsa.mail2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.w3c.dom.Document;

public interface MailMessageBuilder {

    MailMessageBuilder withAttachement(byte[] binaryData, String mimeType, String fileName)
	    throws MailBuilderException;

    MailMessageBuilder withAttachement(byte[] binaryData, String mimeType, String fileName, String contentId)
	    throws MailBuilderException;

    MailMessageBuilder withAttachement(Document doc, String fileName) throws MailBuilderException;

    MailMessageBuilder withAttachement(Document doc, String fileName, Charset charset)
	    throws MailBuilderException;

    MailMessageBuilder withAttachement(Document doc, String fileName, Charset charset, String contentId)
	    throws MailBuilderException;

    MailMessageBuilder withAttachement(Document doc, String fileName, String contentId)
	    throws MailBuilderException;

    MailMessageBuilder withAttachement(Exception e, String fileName) throws MailBuilderException;

    MailMessageBuilder withAttachement(Exception e, String fileName, String contentId)
	    throws MailBuilderException;

    MailMessageBuilder withAttachement(File file) throws MailBuilderException, IOException;

    MailMessageBuilder withAttachement(File file, String contentId) throws MailBuilderException, IOException;

    MailMessageBuilder withAttachement(InputStream inputStream, String mimeType, String fileName)
	    throws MailBuilderException, IOException;

    MailMessageBuilder withAttachement(InputStream inputStream, String mimeType, String fileName, String contentId)
	    throws MailBuilderException, IOException;

    MailMessageBuilder withAttachement(String textContent, String fileName)
	    throws MailBuilderException;

    MailMessageBuilder withAttachement(String textContent, String fileName, Charset charset)
	    throws MailBuilderException;

    MailMessageBuilder withAttachement(String textContent, String fileName, Charset charset, String contentId)
	    throws MailBuilderException;

    MailMessageBuilder withAnotherBCCRecipient(String address) throws MailBuilderException;

    MailMessageBuilder withAnotherBCCRecipient(String address, String friendlyName) throws MailBuilderException;

    MailMessageBuilder withAnotherCCRecipient(String address) throws MailBuilderException;

    MailMessageBuilder withAnotherCCRecipient(String address, String friendlyName) throws MailBuilderException;

    MailMessageBuilder withPartDocument(Document doc) throws MailBuilderException;

    MailMessageBuilder withPartDocument(Document doc, Charset charset) throws MailBuilderException;

    MailMessageBuilder withPartDocument(Document doc, Charset charset, String contentId)
	    throws MailBuilderException;

    MailMessageBuilder withPartDocument(Document doc, String contentId) throws MailBuilderException;

    MailMessageBuilder withPartException(Exception e) throws MailBuilderException;

    MailMessageBuilder withPartException(Exception e, String contentId) throws MailBuilderException;

    MailMessageBuilder withPartHtml(String html) throws MailBuilderException;

    MailMessageBuilder withPartHtml(String html, Charset charset) throws MailBuilderException;

    MailMessageBuilder withPartHtml(String html, Charset charset, String contentId) throws MailBuilderException;

    MailMessageBuilder withPartHtml(String html, String contentId) throws MailBuilderException;

    MailMessageBuilder withPartInline(byte[] binaryData, String mimeType)
	    throws MailBuilderException;

    MailMessageBuilder withPartInline(byte[] binaryData, String mimeType, String contentId)
	    throws MailBuilderException;

    MailMessageBuilder withPartInline(File file) throws MailBuilderException, IOException;

    MailMessageBuilder withPartInline(File file, String contentId) throws MailBuilderException, IOException;

    MailMessageBuilder withPartInline(InputStream inputStream, String mimeType)
	    throws MailBuilderException, IOException;

    MailMessageBuilder withPartInline(InputStream inputStream, String mimeType, String contentId)
	    throws MailBuilderException, IOException;

    MailMessageBuilder withPartText(String text) throws MailBuilderException;

    MailMessageBuilder withPartText(String text, Charset charset) throws MailBuilderException;

    MailMessageBuilder withPartText(String text, Charset charset, String contentId) throws MailBuilderException;

    MailMessageBuilder withPartText(String text, String contentId) throws MailBuilderException;

    MailMessageBuilder withAnotherTORecipient(String address) throws MailBuilderException;

    MailMessageBuilder withAnotherTORecipient(String address, String friendlyName) throws MailBuilderException;

    MailMessage build() throws MailBuilderException;

    MailMessageBuilder withBCCRecipient(String address) throws MailBuilderException;

    MailMessageBuilder withBCCRecipient(String address, String friendlyName) throws MailBuilderException;

    MailMessageBuilder withCCRecipient(String address) throws MailBuilderException;

    MailMessageBuilder withCCRecipient(String address, String friendlyName) throws MailBuilderException;

    MailMessageBuilder withCharset(Charset defaultCharset) throws MailBuilderException;

    MailMessageBuilder withSender(String address) throws MailBuilderException;

    MailMessageBuilder withSender(String address, String friendlyName) throws MailBuilderException;

    MailMessageBuilder withSubject(String subject) throws MailBuilderException;

    MailMessageBuilder withTORecipient(String address) throws MailBuilderException;

    MailMessageBuilder withTORecipient(String address, String friendlyName) throws MailBuilderException;

    MailMessageBuilder withDefaultRecipient() throws MailBuilderException;

    MailMessageBuilder withDefaultSender() throws MailBuilderException;

    MailMessageBuilder withDefaultCharset() throws MailBuilderException;

}

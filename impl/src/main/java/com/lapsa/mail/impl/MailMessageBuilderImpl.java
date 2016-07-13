package com.lapsa.mail.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.w3c.dom.Document;

import com.lapsa.mail.AttachementType;
import com.lapsa.mail.MailAddress;
import com.lapsa.mail.MailException;
import com.lapsa.mail.MailMessage;
import com.lapsa.mail.MailMessageAttachementPart;
import com.lapsa.mail.MailMessageBuilder;
import com.lapsa.mail.MailMessageByteArrayPart;
import com.lapsa.mail.MailMessageFilePart;
import com.lapsa.mail.MailMessageHTMLPart;
import com.lapsa.mail.MailMessageStreamPart;
import com.lapsa.mail.MailMessageTextPart;
import com.lapsa.mail.MailMessageXMLPart;
import com.lapsa.mail.MailService;

public class MailMessageBuilderImpl implements MailMessageBuilder {

    MailMessageBuilderImpl(MailService mailService) {
    }

    @Override
    public MailMessageFilePart createFilePart(File file) throws MailException {
	return new MailMessageFilePartImpl(file);
    }

    @Override
    public MailMessageFilePart createFilePart(File file, String contentId) throws MailException {
	return new MailMessageFilePartImpl(file, contentId);
    }

    @Override
    public MailMessageHTMLPart createHTMLPart(String html) throws MailException {
	return new MailMessageHTMLPartImpl(html, Charset.defaultCharset());
    }

    @Override
    public MailMessageHTMLPart createHTMLPart(String html, String contentId) throws MailException {
	return new MailMessageHTMLPartImpl(html, Charset.defaultCharset(), contentId);
    }

    @Override
    public MailAddress createAddress(String eMail, String name) throws MailException {
	return new MailAddressImpl(eMail, name);
    }

    @Override
    public MailMessageTextPart createTextPart(String text) throws MailException {
	return new MailMessageTextPartImpl(text, Charset.defaultCharset());
    }

    @Override
    public MailMessageTextPart createTextPart(String text, String contentId) throws MailException {
	return new MailMessageTextPartImpl(text, Charset.defaultCharset(), contentId);
    }

    @Override
    public MailMessageHTMLPart createHTMLPart(String html, Charset charset) throws MailException {
	return new MailMessageHTMLPartImpl(html, charset);
    }

    @Override
    public MailMessageHTMLPart createHTMLPart(String html, Charset charset, String contentId) throws MailException {
	return new MailMessageHTMLPartImpl(html, charset, contentId);
    }

    @Override
    public MailMessageTextPart createTextPart(String text, Charset charset) throws MailException {
	return new MailMessageTextPartImpl(text, charset);
    }

    @Override
    public MailMessageTextPart createTextPart(String text, Charset charset, String contentId) throws MailException {
	return new MailMessageTextPartImpl(text, charset, contentId);
    }

    @Override
    public MailMessageTextPart createTextPart(Exception e) throws MailException {
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	e.printStackTrace(pw);
	return createTextPart(sw.toString());
    }

    @Override
    public MailMessageTextPart createTextPart(Exception e, String contentId) throws MailException {
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	e.printStackTrace(pw);
	return createTextPart(sw.toString(), contentId);
    }

    @Override
    public MailMessageXMLPart createXMLPart(Document doc) throws MailException {
	return new MailMessageXMLPartImpl(doc, Charset.defaultCharset());
    }

    @Override
    public MailMessageXMLPart createXMLPart(Document doc, String contentId) throws MailException {
	return new MailMessageXMLPartImpl(doc, Charset.defaultCharset(), contentId);
    }

    @Override
    public MailMessageXMLPart createXMLPart(Document doc, Charset charset) throws MailException {
	return new MailMessageXMLPartImpl(doc, charset);
    }

    @Override
    public MailMessageXMLPart createXMLPart(Document doc, Charset charset, String contentId) throws MailException {
	return new MailMessageXMLPartImpl(doc, charset, contentId);
    }

    @Override
    public MailAddress createAddress(String eMail) throws MailException {
	return new MailAddressImpl(eMail, "");
    }

    @Override
    public MailMessageStreamPart createStreamPart(String name, String contentType, InputStream inputStream)
	    throws MailException, IOException {
	return new MailMessageStreamPartImpl(name, contentType, inputStream);
    }

    @Override
    public MailMessageStreamPart createStreamPart(String name, String contentType, InputStream inputStream,
	    boolean readImmediately) throws MailException, IOException {
	return new MailMessageStreamPartImpl(name, contentType, inputStream, readImmediately);
    }

    @Override
    public MailMessageStreamPart createStreamPart(String name, String contentType, InputStream inputStream,
	    String contentId) throws MailException, IOException {
	return new MailMessageStreamPartImpl(name, contentType, inputStream, contentId);
    }

    @Override
    public MailMessageStreamPart createStreamPart(String name, String contentType, InputStream inputStream,
	    boolean readImmediately, String contentId) throws MailException, IOException {
	return new MailMessageStreamPartImpl(name, contentType, inputStream, readImmediately, contentId);
    }

    @Override
    public MailMessageByteArrayPart createByteArrayPart(String name, String contentType, byte[] bytes)
	    throws MailException, IOException {
	return new MailMessageByteArrayPartImpl(name, contentType, bytes);
    }

    @Override
    public MailMessageByteArrayPart createByteArrayPart(String name, String contentType, byte[] bytes, String contentId)
	    throws MailException, IOException {
	return new MailMessageByteArrayPartImpl(name, contentType, bytes, contentId);
    }

    @Override
    public MailMessage createMessage() throws MailException {
	return createMessage(null, null, null, null);
    }

    @Override
    public MailMessage createMessage(Charset charset) throws MailException {
	return createMessage(null, null, null, charset);
    }

    @Override
    public MailMessage createMessage(String subject) throws MailException {
	return createMessage(null, null, subject, null);
    }

    @Override
    public MailMessage createMessage(MailAddress from, MailAddress to, String subject) throws MailException {
	return createMessage(from, to, subject, null);
    }

    @Override
    public MailMessage createMessage(String subject, Charset charset) throws MailException {
	return createMessage(null, null, subject, charset);
    }

    @Override
    public MailMessage createMessage(MailAddress from, MailAddress to, String subject, Charset charset)
	    throws MailException {
	MailMessage mm = new MailMessageImpl();
	if (from != null)
	    mm.setFrom(from);
	if (to != null)
	    mm.addTORecipient(to);
	if (subject != null)
	    mm.setSubject(subject);
	if (charset != null)
	    mm.setCharset(charset);
	return mm;
    }

    @Override
    public MailMessage createMessage(MailAddress to, String subject) throws MailException {
	return createMessage(null, to, subject, null);
    }

    @Override
    public MailMessage createMessage(MailAddress to, String subject, Charset charset) throws MailException {
	return createMessage(null, to, subject, charset);
    }

    /*
     * createInlineImagePart methods
     */

    /*
     * source File
     */

    @Override
    public MailMessageAttachementPart createInlineImagePart(String contentType, File file)
	    throws MailException, IOException {
	try (FileInputStream fis = new FileInputStream(file)) {
	    byte[] bytes = readBytes(fis);
	    return new MailMessageAttachementPartImpl(contentType, bytes, file.getName(), null, AttachementType.INLINE);
	}
    }

    @Override
    public MailMessageAttachementPart createInlineImagePart(String contentType, File file, String contentId)
	    throws MailException, IOException {
	try (FileInputStream fis = new FileInputStream(file)) {
	    byte[] bytes = readBytes(fis);
	    return new MailMessageAttachementPartImpl(contentType, bytes, file.getName(), contentId,
		    AttachementType.INLINE);
	}
    }

    /*
     * source InputStream
     */

    @Override
    public MailMessageAttachementPart createInlineImagePart(String contentType, InputStream inputStream,
	    String fileName) throws MailException, IOException {
	byte[] bytes = readBytes(inputStream);
	return new MailMessageAttachementPartImpl(contentType, bytes, fileName, null, AttachementType.INLINE);
    }

    @Override
    public MailMessageAttachementPart createInlineImagePart(String contentType, InputStream inputStream,
	    String fileName, String contentId) throws MailException, IOException {
	byte[] bytes = readBytes(inputStream);
	return new MailMessageAttachementPartImpl(contentType, bytes, fileName, contentId, AttachementType.INLINE);
    }

    // createAttachement methods

    @Override
    public MailMessageAttachementPart createTextAttachement(String content, String contentType, String fileName) {
	byte[] bytes = content.getBytes();
	return createBytesAttachement(bytes, contentType, fileName);
    }

    @Override
    public MailMessageAttachementPart createTextAttachement(String content, String contentType, String fileName,
	    String contentId) {
	byte[] bytes = content.getBytes();
	return createBytesAttachement(bytes, contentType, fileName, contentId);
    }

    @Override
    public MailMessageAttachementPart createBytesAttachement(byte[] content, String contentType, String fileName) {
	return new MailMessageAttachementPartImpl(contentType, content, fileName, null, AttachementType.ATTACHEMENT);
    }

    @Override
    public MailMessageAttachementPart createBytesAttachement(byte[] content, String contentType, String fileName,
	    String contentId) {
	return new MailMessageAttachementPartImpl(contentType, content, fileName, contentId,
		AttachementType.ATTACHEMENT);
    }

    @Override
    public MailMessageAttachementPart createStreamAttachement(InputStream content, String contentType,
	    String fileName) throws IOException {
	return createStreamAttachement(content, contentType, fileName, null);
    }

    @Override
    public MailMessageAttachementPart createStreamAttachement(InputStream content, String contentType, String fileName,
	    String contentId) throws IOException {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	int readed = -1;
	byte[] buff = new byte[256];
	while ((readed = content.read(buff)) != -1)
	    baos.write(buff, 0, readed);
	return createBytesAttachement(baos.toByteArray(), contentType, fileName, contentId);
    }

    // PRIVATE

    private byte[] readBytes(InputStream inputStream) throws IOException {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	int readed = -1;
	byte[] buff = new byte[256];
	while ((readed = inputStream.read(buff)) != -1)
	    baos.write(buff, 0, readed);
	return baos.toByteArray();
    }

}
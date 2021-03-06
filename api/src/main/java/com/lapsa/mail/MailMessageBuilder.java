package com.lapsa.mail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.w3c.dom.Document;

public interface MailMessageBuilder {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    /*
     * createAddress methods
     */
    MailAddress createAddress(String smtpAddress) throws MailException;

    MailAddress createAddress(String smtpAddress, String friendlyName) throws MailException;

    /*
     * createMessage methods
     */
    MailMessage createMessage() throws MailException;

    MailMessage createMessage(Charset charset) throws MailException;

    MailMessage createMessage(String subject) throws MailException;

    MailMessage createMessage(String subject, Charset charset) throws MailException;

    MailMessage createMessage(MailAddress to, String subject) throws MailException;

    MailMessage createMessage(MailAddress to, String subject, Charset charset) throws MailException;

    MailMessage createMessage(MailAddress from, MailAddress to, String subject) throws MailException;

    MailMessage createMessage(MailAddress from, MailAddress to, String subject, Charset charset) throws MailException;

    /*
     * createTextPart methods
     */
    MailMessageTextPart createTextPart(String text) throws MailException;

    MailMessageTextPart createTextPart(String text, String contentId) throws MailException;

    MailMessageTextPart createTextPart(String text, Charset charset) throws MailException;

    MailMessageTextPart createTextPart(String text, Charset charset, String contentId) throws MailException;

    MailMessageTextPart createTextPart(Exception e) throws MailException;

    MailMessageTextPart createTextPart(Exception e, String contentId) throws MailException;

    /*
     * createHTMLPart methods
     */
    MailMessageHTMLPart createHTMLPart(String html) throws MailException;

    MailMessageHTMLPart createHTMLPart(String html, String contentId) throws MailException;

    MailMessageHTMLPart createHTMLPart(String html, Charset charset) throws MailException;

    MailMessageHTMLPart createHTMLPart(String html, Charset charset, String contentId) throws MailException;

    /*
     * createXMLPart methods
     */
    MailMessagePart createXMLPart(Document doc) throws MailException;

    MailMessagePart createXMLPart(Document doc, String contentId) throws MailException;

    MailMessagePart createXMLPart(Document doc, Charset charset) throws MailException;

    MailMessagePart createXMLPart(Document doc, Charset charset, String contentId) throws MailException;

    /*
     * createFilePart methods
     */
    MailMessageFilePart createFilePart(File file) throws MailException;

    MailMessageFilePart createFilePart(File file, String contentId) throws MailException;

    /*
     * createStreamPart methods
     */
    MailMessageStreamPart createStreamPart(String name, String contentType, InputStream inputStream)
	    throws MailException, IOException;

    MailMessageStreamPart createStreamPart(String name, String contentType, InputStream inputStream,
	    boolean readImmediately)
	    throws MailException, IOException;

    MailMessageStreamPart createStreamPart(String name, String contentType, InputStream inputStream, String contentId)
	    throws MailException, IOException;

    MailMessageStreamPart createStreamPart(String name, String contentType, InputStream inputStream,
	    boolean readImmediately, String contentId)
	    throws MailException, IOException;

    /*
     * createByteArrayPart methods
     */
    MailMessageByteArrayPart createByteArrayPart(String name, String contentType, byte[] bytes)
	    throws MailException, IOException;

    MailMessageByteArrayPart createByteArrayPart(String name, String contentType, byte[] bytes, String contentId)
	    throws MailException, IOException;

    /*
     * createInlineImagePart methods
     */

    /*
     * source File
     */
    MailMessageAttachementPart createInlineImagePart(String contentType, File file) throws MailException, IOException;

    MailMessageAttachementPart createInlineImagePart(String contentType, File file, String contentId)
	    throws MailException, IOException;

    /*
     * source InputStream
     */
    MailMessageAttachementPart createInlineImagePart(String contentType, InputStream inputStream, String fileName)
	    throws MailException, IOException;

    MailMessageAttachementPart createInlineImagePart(String contentType, InputStream inputStream, String fileName,
	    String contentId)
	    throws MailException, IOException;

    // createAttachement methods

    MailMessageAttachementPart createTextAttachement(String content, String contentType, String fileName);

    MailMessageAttachementPart createTextAttachement(String content, String contentType, String fileName,
	    String contentId);

    MailMessageAttachementPart createBytesAttachement(byte[] content, String contentType, String fileName);

    MailMessageAttachementPart createBytesAttachement(byte[] content, String contentType, String fileName,
	    String contentId);

    MailMessageAttachementPart createStreamAttachement(InputStream content, String contentType, String fileName)
	    throws IOException;

    MailMessageAttachementPart createStreamAttachement(InputStream content, String contentType, String fileName,
	    String contentId) throws IOException;

}

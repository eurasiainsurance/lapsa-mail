package tech.lapsa.lapsa.mail;

import java.nio.charset.Charset;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.function.Predicate;

public interface MailFactoryBuilder {

    MailFactory build() throws MailBuilderException;

    MailFactoryBuilder withAlwaysBlindCopyTo(String address) throws MailBuilderException;

    MailFactoryBuilder withAlwaysBlindCopyTo(String address, String friendlyName) throws MailBuilderException;

    MailFactoryBuilder withAuth(String user, String password) throws MailBuilderException;

    MailFactoryBuilder withDebug(boolean debug) throws MailBuilderException;

    MailFactoryBuilder withDefaultCharset(Charset charset) throws MailBuilderException;

    MailFactoryBuilder withDefaultRecipient(String address) throws MailBuilderException;

    MailFactoryBuilder withDefaultRecipient(String address, String friendlyName) throws MailBuilderException;

    MailFactoryBuilder withDefaultSender(String address) throws MailBuilderException;

    MailFactoryBuilder withDefaultSender(String address, String friendlyName) throws MailBuilderException;

    MailFactoryBuilder withForwardAllMailTo(String address) throws MailBuilderException;

    MailFactoryBuilder withForwardAllMailTo(String address, String friendlyName) throws MailBuilderException;

    MailFactoryBuilder withProperties(Properties props) throws MailBuilderException;

    // STATIC

    static MailFactoryBuilder newBuilder() throws MailBuilderException {
	return newBuilder(factory -> true);
    }

    static MailFactoryBuilder newBuilder(final Predicate<MailFactoryBuilder> func) throws MailBuilderException {
	final ServiceLoader<MailFactoryBuilder> mailFactorySPI = ServiceLoader.load(MailFactoryBuilder.class);
	for (final MailFactoryBuilder factory : mailFactorySPI)
	    if (func.test(factory))
		return factory;
	throw new MailBuilderException("There is no any registered MailFactoryBuilder service provider");
    }

    @SuppressWarnings("unchecked")
    static <T extends MailFactoryBuilder> MailFactoryBuilder newBuilder(final String implementationClass)
	    throws MailBuilderException, ClassNotFoundException {
	return newMailFactoryBuilder((Class<T>) Class.forName(implementationClass));
    }

    static <T extends MailFactoryBuilder> MailFactoryBuilder newMailFactoryBuilder(final Class<T> clazz)
	    throws MailBuilderException {
	return newBuilder(factory -> factory.getClass() == clazz);
    }

}

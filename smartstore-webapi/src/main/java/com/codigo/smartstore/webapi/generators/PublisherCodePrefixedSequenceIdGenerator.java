package com.codigo.smartstore.webapi.generators;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

/**
 * <pre>
 *
 * &#64;Id
 * &#64;GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
 * &#64;GenericGenerator(
 * 	name = "book_seq",
 * 	strategy = "org.thoughts.on.java.generators.PublisherCodePrefixedSequenceIdGenerator",
 * 	parameters = {
 * 		&#64;Parameter(name = PublisherCodePrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
 * 		&#64;Parameter(name = PublisherCodePrefixedSequenceIdGenerator.CODE_NUMBER_SEPARATOR_PARAMETER, value = "_"),
 * 		&#64;Parameter(name = PublisherCodePrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
 * private String id;
 * </pre>
 *
 * @author dp0470
 *
 */
public class PublisherCodePrefixedSequenceIdGenerator
		extends
		SequenceStyleGenerator {

	public static final String CODE_NUMBER_SEPARATOR_PARAMETER = "codeNumberSeparator";
	public static final String CODE_NUMBER_SEPARATOR_DEFAULT = "_";

	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%05d";

	@Override
	public Serializable generate(final SharedSessionContractImplementor session, final Object object)
			throws HibernateException {

		return "";
		//
		// return String.format(
		// this.format,
		// ((Book) object).getPublisher()
		// .getCode(),
		// super.generate(session, object));
	}

	@Override
	public void configure(final Type type, final Properties params, final ServiceRegistry serviceRegistry)
			throws MappingException {

		super.configure(LongType.INSTANCE, params, serviceRegistry);
		final String codeNumberSeparator = ConfigurationHelper.getString(CODE_NUMBER_SEPARATOR_PARAMETER, params,
			CODE_NUMBER_SEPARATOR_DEFAULT);
		final String numberFormat = ConfigurationHelper
				.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT)
				.replace("%", "%2");
	}
}
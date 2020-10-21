package com.codigo.smartstore.webapi.generators;

import java.io.Serializable;
import java.time.LocalDate;
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
 * <code>@Id
    &#64;GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    &#64;GenericGenerator(
        name = "book_seq",
        strategy = "org.thoughts.on.java.generators.DatePrefixedSequenceIdGenerator",
        parameters = {@Parameter(name = DatePrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50")})
    private String id;</code>
 *
 * @author dp0470
 *
 */
public class DatePrefixedSequenceIdGenerator
		extends
		SequenceStyleGenerator {

	public static final String DATE_FORMAT_PARAMETER = "dateFormat";
	public static final String DATE_FORMAT_DEFAULT = "%tY-%tm";

	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%05d";

	public static final String DATE_NUMBER_SEPARATOR_PARAMETER = "dateNumberSeparator";
	public static final String DATE_NUMBER_SEPARATOR_DEFAULT = "_";

	private String format;

	@Override
	public Serializable generate(final SharedSessionContractImplementor session, final Object object)
			throws HibernateException {

		return String.format(this.format, LocalDate.now(), super.generate(session, object));
	}

	@Override
	public void configure(final Type type, final Properties params, final ServiceRegistry serviceRegistry)
			throws MappingException {

		super.configure(LongType.INSTANCE, params, serviceRegistry);

		final String dateFormat = ConfigurationHelper.getString(DATE_FORMAT_PARAMETER, params, DATE_FORMAT_DEFAULT)
				.replace("%", "%1");

		final String numberFormat = ConfigurationHelper
				.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT)
				.replace("%", "%2");

		final String dateNumberSeparator = ConfigurationHelper
				.getString(DATE_NUMBER_SEPARATOR_PARAMETER, params, DATE_NUMBER_SEPARATOR_DEFAULT);

		this.format = dateFormat + dateNumberSeparator
				+ numberFormat;
	}
}

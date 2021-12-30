package org.mirrentools.sd.converter.impl.postgresql;

import org.mirrentools.sd.SdType;
import org.mirrentools.sd.converter.SdAbstractTableContentConverter;
import org.mirrentools.sd.converter.SdBasicTypeConverter;
import org.mirrentools.sd.converter.SdTypeConverter;
import org.mirrentools.sd.enums.SdTypeMode;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdColumn;
import org.mirrentools.sd.models.SdSequence;
import org.mirrentools.sd.models.db.update.SdAbstractColumnContent;
import org.mirrentools.sd.models.db.update.SdAbstractConstraintContent;
import org.mirrentools.sd.models.db.update.SdAbstractForeignKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractIndexKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;
import org.mirrentools.sd.models.db.update.SdAbstractSequenceContent;
import org.mirrentools.sd.models.db.update.SdAbstractTableContent;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdColumnContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdConstraintContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdForeignKeyContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdIndexKeyContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdPrimaryKeyContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdSequenceContentByPostgreSQL;
import org.mirrentools.sd.models.db.update.impl.postgresql.SdTableContentByPostgreSQL;

/**
 * 将SdBean转换为PostgreSQL数据库创建表需要的内容
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdTableContentConverterPostgreSqlImpl extends SdAbstractTableContentConverter {

	public SdTableContentConverterPostgreSqlImpl() {
		super(new SdBasicTypeConverter("ScrewDriver UNKNOWN TYPE", SdType.getDictionary(SdTypeMode.POSTGRE_SQL)));
	}

	public SdTableContentConverterPostgreSqlImpl(SdTypeConverter typeConverter) {
		super(typeConverter);
	}

	@Override
	public SdAbstractTableContent newTableContent(SdBean bean) {
		SdTableContentByPostgreSQL result = new SdTableContentByPostgreSQL();
		if (bean.getSchema() != null && !bean.getSchema().equals("")) {
			result.setSchema(bean.getSchema());
		}
		return result;
	}

	@Override
	public SdAbstractColumnContent newColumnContent(SdColumn col) {
		return new SdColumnContentByPostgreSQL();
	}

	@Override
	public SdAbstractPrimaryKeyContent newPrimaryKeyContent(SdColumn col) {
		return new SdPrimaryKeyContentByPostgreSQL();
	}

	@Override
	public SdAbstractIndexKeyContent newIndexKeyContent(SdColumn col) {
		return new SdIndexKeyContentByPostgreSQL();
	}

	@Override
	public SdAbstractForeignKeyContent newForeignKeyContent(SdColumn col) {
		return new SdForeignKeyContentByPostgreSQL();
	}

	@Override
	public SdAbstractConstraintContent newConstraintContent(SdColumn col) {
		return new SdConstraintContentByPostgreSQL();
	}

	@Override
	public SdAbstractSequenceContent newSequenceContent(SdSequence sequence) {
		return new SdSequenceContentByPostgreSQL();
	}
}
